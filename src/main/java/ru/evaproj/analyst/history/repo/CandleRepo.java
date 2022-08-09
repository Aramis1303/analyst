package ru.evaproj.analyst.history.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.history.entity.CandleEntity;

import java.util.List;

@Repository
public interface CandleRepo extends JpaRepository<CandleEntity, Long> {

    List<CandleEntity> findAllByMarketNameAndTimeframe(@Param("marketName")String marketName, @Param("timeframe")Integer timeframe);

    @Query(nativeQuery = true, value = "select ce from CandleEntity ce where ce.marketName = ?1 and ce.timeframe = ?2 and ce.timestamp <= ?3 ORDER BY ce.timestamp DESC LIMIT ?4")
    List<CandleEntity> findCandleListByMarketNameAndTimeframeTillTimestamp(String marketName, Long timeframe, Long timestamp, Long depth);

    @Query(nativeQuery = true, value = "SELECT DISTINCT ce.marketName FROM CandleEntity ce")
    List<String> findAllMarketNames();

}

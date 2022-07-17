package ru.evaproj.analyst.history.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.models.Timeframe;

import java.util.List;

@Repository
public interface CandleRepo extends JpaRepository<CandleEntity, Long> {

    List<CandleEntity> findAllByMarketNameAndTimeframe(@Param("marketName")String marketName, @Param("timeframe")Timeframe timeframe);

    @Query(nativeQuery = true, value = "select ce from CandleEntity ce where ce.marketName = ?2 and ce.timeframe = ?3 ORDER BY ce.timestamp DESC LIMIT ?1")
    List<CandleEntity> findLastFewByMarketNameAndTimeframe(Long quantity, String marketName, Timeframe timeframe);


}

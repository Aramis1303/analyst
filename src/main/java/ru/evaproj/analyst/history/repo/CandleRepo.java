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

    @Query(value = "SELECT ce FROM CandleEntity ce WHERE ce.marketName = :marketName and ce.timeframe = :timeframe and ce.timestamp >= :fromTimestamp and ce.timestamp <= :toTimestamp ORDER BY ce.timestamp DESC")
    List<CandleEntity> findRangeByMarketNameAndTimeframe(String marketName, Integer timeframe, Long fromTimestamp, Long toTimestamp);

    @Query(nativeQuery = true, value = "SELECT * FROM `candle` WHERE `market_name` = ?1 AND `timeframe` = ?2 AND `timestamp` <= ?3 ORDER BY `timestamp` DESC LIMIT ?4")
    List<CandleEntity> findCandleListByMarketNameAndTimeframeTillTimestamp(String marketName, Long timeframe, Long timestamp, Long depth);

    @Query(value = "SELECT ce FROM CandleEntity ce WHERE ce.marketName = :marketName and ce.timeframe = :timeframe and ce.timestamp <= :timestamp ORDER BY ce.timestamp DESC")
    List<CandleEntity> findAllCandleListByMarketNameAndTimeframeTillTimestamp(String marketName, Long timeframe, Long timestamp);

    @Query(value = "SELECT DISTINCT marketName FROM CandleEntity")
    List<String> findAllMarketNames();

}

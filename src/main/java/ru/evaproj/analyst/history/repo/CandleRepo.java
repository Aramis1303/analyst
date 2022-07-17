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

    List<CandleEntity> findAllByMarketNameAndTimeframe();

    @Query(nativeQuery = true, value = "select ce from CandleEntity ce where ce.marketName =: marketName and ce.timeframe = :timeframe ORDER BY ce.timestamp DESC LIMIT :quantity")
    List<CandleEntity> findLastFewByMarketNameAndTimeframe(@Param("quantity") Long quantity, @Param("marketName") String marketName, @Param("timeframe") Timeframe timeframe);


}

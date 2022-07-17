package ru.evaproj.analyst.history.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.history.entity.MarketEntity;

import java.util.List;

@Repository
public interface MarketRepo extends JpaRepository<MarketEntity, Long> {

    @Query(value = "SELECT market FROM MarketEntity market ORDER BY market.name")
    List<MarketEntity> getAllNames ();

}

package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.BalanceEntity;

@Repository
public interface BalanceRepo extends JpaRepository<BalanceEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT be FROM BalanceEntity be ORDER BY be.timestamp DESC TOP 1")
    BalanceEntity findTopOrderByTimestamp();
}

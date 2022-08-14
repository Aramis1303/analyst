package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.BalanceEntity;
import ru.evaproj.analyst.management.models.ProcessStatus;

@Repository
public interface BalanceRepo extends JpaRepository<BalanceEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT be FROM BalanceEntity be WHERE be = :status ORDER BY be.timestamp DESC TOP 1")
    BalanceEntity findLastBalanceByStatus(ProcessStatus status);
}

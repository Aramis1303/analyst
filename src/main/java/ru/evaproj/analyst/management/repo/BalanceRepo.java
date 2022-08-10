package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.BalanceEntity;

@Repository
public interface BalanceRepo extends JpaRepository<BalanceEntity, Long> {

    BalanceEntity findTopOrderByTimestamp();
}

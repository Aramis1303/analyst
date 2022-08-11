package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.ManagementEntity;
import ru.evaproj.analyst.management.models.OrderTypeEnum;
import ru.evaproj.analyst.management.models.OrderStatusEnum;

import java.util.List;

@Repository
public interface ManagementRepo extends JpaRepository<ManagementEntity, Long> {

    @Query("SELECT me FROM ManagementEntity me WHERE me.dealType = :dealType AND me.status = :status ORDER BY me.timestamp DESC")
    List<ManagementEntity> findByDealTypeAndStatusOrder(OrderTypeEnum dealType, OrderStatusEnum status);

    ManagementEntity findTopByStatusAndMarketNameOrderByTimestamp(OrderStatusEnum status, String marketName);

    ManagementEntity findByTimestamp(Long timestamp);

}

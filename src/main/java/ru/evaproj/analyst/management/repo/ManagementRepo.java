package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.ManagementEntity;
import ru.evaproj.analyst.management.models.DealTypeEnum;
import ru.evaproj.analyst.management.models.ManagementDealStatusEnum;

import java.util.List;

@Repository
public interface ManagementRepo extends JpaRepository<ManagementEntity, Long> {

    @Query("SELECT me FROM ManagementEntity me WHERE me.dealType = :dealType AND me.status = :status ORDER BY me.timestamp DESC")
    List<ManagementEntity> findByDealTypeAndStatusOrder(DealTypeEnum dealType, ManagementDealStatusEnum status);

    ManagementEntity findTopByStatusAndMarketNameOrderByTimestamp(ManagementDealStatusEnum status, String marketName);

    ManagementEntity findByTimestamp(Long timestamp);

    @Query("SELECT me FROM ManagementEntity me WHERE me.dealType = :dealType AND me.status = :status ORDER BY me.timestamp DESC")
    ManagementEntity cancelQuery(Long timestamp);

}

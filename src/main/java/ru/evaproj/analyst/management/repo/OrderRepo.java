package ru.evaproj.analyst.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evaproj.analyst.management.entity.OrderEntity;
import ru.evaproj.analyst.management.models.OrderType;
import ru.evaproj.analyst.management.models.ProcessStatus;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT me FROM OrderEntity me WHERE me.orderType = :orderType AND me.status = :status ORDER BY me.timestamp DESC")
    List<OrderEntity> findByOrderTypeAndStatusOrder(OrderType orderType, ProcessStatus status);

    @Query(nativeQuery = true, value = "SELECT me FROM OrderEntity me WHERE me.marketName = :marketName AND me.status = :status ORDER BY me.timestamp DESC TOP :limit")
    List<OrderEntity> findTopByOrderTypeAndStatus(String marketName, ProcessStatus status, Long limit);

    OrderEntity findTopByStatusAndMarketNameOrderByTimestamp(ProcessStatus status, String marketName);

    OrderEntity findByTimestamp(Long timestamp);

}

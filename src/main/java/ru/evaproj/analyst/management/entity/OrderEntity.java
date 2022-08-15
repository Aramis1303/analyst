package ru.evaproj.analyst.management.entity;

import lombok.Data;
import ru.evaproj.analyst.management.models.OrderType;
import ru.evaproj.analyst.management.models.ProcessStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private Long timestamp;

    @NotNull
    private OrderType orderType;

    @NotNull
    private ProcessStatus status;

    @NotNull
    private String marketName;

    private Long ticket;

}

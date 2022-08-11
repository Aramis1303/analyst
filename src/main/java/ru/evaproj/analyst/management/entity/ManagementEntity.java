package ru.evaproj.analyst.management.entity;

import lombok.Data;
import ru.evaproj.analyst.management.models.OrderTypeEnum;
import ru.evaproj.analyst.management.models.OrderStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "management")
public class ManagementEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private Long timestamp;

    @NotNull
    private OrderTypeEnum dealType;

    @NotNull
    private OrderStatusEnum status;

    @NotNull
    private String marketName;

}

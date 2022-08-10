package ru.evaproj.analyst.management.entity;

import lombok.Data;
import ru.evaproj.analyst.management.models.DealTypeEnum;
import ru.evaproj.analyst.management.models.ManagementDealStatusEnum;

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
    private DealTypeEnum dealType;

    @NotNull
    private ManagementDealStatusEnum status;

    @NotNull
    private String marketName;

}

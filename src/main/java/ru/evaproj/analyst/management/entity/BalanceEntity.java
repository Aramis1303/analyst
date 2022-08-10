package ru.evaproj.analyst.management.entity;

import lombok.Data;
import ru.evaproj.analyst.management.models.BalanceQueryStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "balance")
public class BalanceEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BalanceQueryStatusEnum status;

    @NotNull
    @Column(unique=true)
    private Long timestamp;

    // баланс
    private Double balance;
    // собственные средства
    private Double equity;
    //совокупная плавающий убыток
    private Double margin;
    //совокупная плавающая прибыль
    private Double floatProfit;
    // свободные средства, не участвующие в залоге
    private Double freeMargin;

}

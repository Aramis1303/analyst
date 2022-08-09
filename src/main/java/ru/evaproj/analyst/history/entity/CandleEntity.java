package ru.evaproj.analyst.history.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "candle", indexes = @Index(
        name = "id_unique",
        columnList = "timestamp, timeframe, market_name",
        unique = true))
public class CandleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double open;
    private Double close;
    private Double high;
    private Double low;

    private Long volume;

    @NotNull
    private Long timestamp;

    @NotNull
    private Long timeframe;

    @NotNull
    @Column(name = "market_name")
    private String marketName;

}

package ru.evaproj.analyst.history.entity;


import lombok.Data;
import ru.evaproj.analyst.history.models.Timeframe;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "market_name_id", "timeframe", "timestamp" } )
})
public class CandleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long timestamp;

    private Long open;
    private Long close;
    private Long high;
    private Long low;
    private Long volume;

    @Enumerated(EnumType.STRING)
    private Timeframe timeframe;

    @ManyToOne
    private MarketEntity marketName;

}

package ru.evaproj.analyst.history.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "markets")
public class MarketEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}

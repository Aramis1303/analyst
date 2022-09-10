package ru.evaproj.analyst.analysis.models;

/*
* STATIC - Статический STOPLOSS
* LAST_CANDLE - STOPLOSS подтягивается к предыдущей свече при открытии новой
* LAST_EXTREMUM - STOPLOSS подтягивается к последнему экстремуму
* CURRENT_PRICE - STOPLOSS подтягивается к текущей цене постоянно
* */
public enum StopLossType {
    STATIC, LAST_CANDLE, LAST_EXTREMUM, CURRENT_PRICE
}

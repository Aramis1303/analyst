package ru.evaproj.analyst.analysis.models;

/*
* STATIC - Статический STOPLOSS
* DYNAMIC_LAST_CANDLE - STOPLOSS подтягивается к предыдущей свече при открытии новой
* DYNAMIC_CURRENT_PRICE - STOPLOSS подтягивается к текущей цене постоянно
* */
public enum StopLossType {
    STATIC, DYNAMIC_LAST_CANDLE, DYNAMIC_CURRENT_PRICE
}

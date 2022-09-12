package ru.evaproj.analyst.analysis.models;

/*
* Все расчеты производятся от цен открытия
* SIMPLE - Поиск на отрезке нобор свечей, направленных в одном направлении
* LAST_CANDLE - Поиск на отрезке экстремумов с разнице в целевом диапазоне с учетом динамического STOPLOSS, подтягивающийся к предыдущей свече
* LAST_EXTREMUM - Поиск на отрезке экстремумов с разнице в целевом диапазоне с учетом динамического STOPLOSS, подтягивающийся к предыдущему экстремуму
* CURRENT_PRICE - Поиск на отрезке экстремумов на скользящей средней
* */
public enum CutterType {
    SIMPLE, LAST_CANDLE, LAST_EXTREMUM, CURRENT_PRICE, AVERAGE_EXTREMUM
}

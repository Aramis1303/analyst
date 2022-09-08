package ru.evaproj.analyst.analysis.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.StopLossType;
import ru.evaproj.analyst.analysis.service.CutterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/segment")
public class CandleSegmentController {

    @Autowired
    CutterServiceImpl cutterService;

    @GetMapping
    @ApiOperation(value = "Нарезка истории", notes = "Метод позволяет получить нарезанные данные отразка графика")
    public ResponseEntity<List<CandleSegmentDto>> getMarketList(
            @ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName,
            @ApiParam(value = "Период свечи", example = "5") Integer timeframe,
            @ApiParam(value = "Время начала диапазона нарезки", example = "1483439400000") Long fromTimestamp,
            @ApiParam(value = "Время окончания диапазона нарезки", example = "1486345900000") Long toTimestamp,
            @ApiParam(value = "Длина отрезка предшествующая целевому движению графика", example = "0") Integer lenght,
            @ApiParam(value = "Движение графика в % которое нас не интересует", example = "0") Double slRange,
            @ApiParam(value = "Целевое изменение цены", example = "0") Double tpRange,
            @ApiParam(value = "Тип STOPLOSS", example = "STATIC, DYNAMIC_LAST_CANDLE, DYNAMIC_CURRENT_PRICE") StopLossType type

    ) {

        return ResponseEntity.ok(
                cutterService.cutHistory(
                        marketName,
                        timeframe,
                        lenght,
                        fromTimestamp,
                        toTimestamp,
                        slRange,
                        tpRange,
                        type
                )
        );
    }


}

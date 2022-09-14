package ru.evaproj.analyst.analysis.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.CutterType;
import ru.evaproj.analyst.analysis.service.CutterService;
import ru.evaproj.analyst.analysis.service.CutterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/segment")
public class CandleSegmentController {

    @Autowired
    CutterService cutterService;

    @GetMapping("/cutting")
    @ApiOperation(value = "Нарезка истории", notes = "Метод позволяет получить нарезанные данные отразка графика")
    public ResponseEntity<List<CandleSegmentDto>> getMarketList(
            @ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName,
            @ApiParam(value = "Период свечи", example = "5") Long timeframe,
            @ApiParam(value = "Время начала диапазона нарезки", example = "1483439400000") Long fromTimestamp,
            @ApiParam(value = "Время окончания диапазона нарезки", example = "1485348600000") Long toTimestamp,
            @ApiParam(value = "Длина отрезка предшествующая целевому движению графика", example = "45") Integer lenght,
            @ApiParam(value = "Stoploss", example = "0.5") Double slRange,
            @ApiParam(value = "Takeprofite", example = "2.0") Double tpRange,
            @ApiParam(value = "Тип Cutter", example = "STATIC") CutterType type

    ) {

        return ResponseEntity.ok(
                cutterService.cutHistory(
                        marketName,
                        timeframe,
                        lenght,
                        (Long)fromTimestamp / 1000,
                        (Long)toTimestamp / 1000,
                        slRange,
                        tpRange,
                        type
                )
        );
    }


}

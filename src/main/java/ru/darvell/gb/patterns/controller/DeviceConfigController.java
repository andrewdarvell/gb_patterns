package ru.darvell.gb.patterns.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.darvell.gb.patterns.api.DeviceConfigDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.darvell.gb.patterns.config.Urls.API_URL;
import static ru.darvell.gb.patterns.config.Urls.DEVICE_CONFIG_URL;

@Tag(name = "Device Config", description = "Сервис для работы с конфигурациями устройств на ноде")
@RestController
@RequestMapping(API_URL + DEVICE_CONFIG_URL)
@CrossOrigin
public class DeviceConfigController {


    @Operation(summary = "Забрать конфиги", description = "Получение всех конфигов устройств")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Успешный ответ от сервиса",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = DeviceConfigDTO.class)))
                    }
            )
    )
    @GetMapping("/")
    public List<DeviceConfigDTO> getAllConfigs(@RequestParam(name = "mask", required = false)
                                               @Parameter(description = "Маска по названию конфига")
                                                       String labelMask
    ) {
        List<DeviceConfigDTO> result = generateMockConfigs();
        if (labelMask != null) {
            result = result.stream().filter(dc -> dc.getLabel().contains(labelMask)).collect(Collectors.toList());
        }
        return result;
    }


    private List<DeviceConfigDTO> generateMockConfigs() {
        return IntStream.rangeClosed(0, 20).boxed()
                .map(i -> new DeviceConfigDTO(String.format("192.128.1.%d", i), 9080L, String.format("Device::%d", i + 10)))
                .collect(Collectors.toList());
    }

}

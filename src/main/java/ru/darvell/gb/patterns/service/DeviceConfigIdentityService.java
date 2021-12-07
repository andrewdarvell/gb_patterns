package ru.darvell.gb.patterns.service;

import ru.darvell.gb.patterns.domain.DeviceConfig;
import ru.darvell.gb.patterns.service.impl.DeviceConfigServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeviceConfigIdentityService implements DeviceConfigService {

    private final DeviceConfigService deviceConfigService = new DeviceConfigServiceImpl();

    private final Map<Long, DeviceConfig> configMaps = new HashMap<>();


    @Override
    public DeviceConfig saveAndFlush(DeviceConfig deviceConfig) {
        deviceConfig = deviceConfigService.saveAndFlush(deviceConfig);
        configMaps.put(deviceConfig.getId(), deviceConfig);
        return fullCopy(deviceConfig);
    }

    @Override
    public Optional<DeviceConfig> findById(long id) {
        DeviceConfig result = fullCopy(configMaps.get(id));
        if (result == null) return deviceConfigService.findById(id);
        return Optional.of(result);
    }

    @Override
    public Optional<DeviceConfig> findByLabel(String label) {
        if (label == null) return Optional.empty();
        Optional<DeviceConfig> result = configMaps.values().stream().filter(c -> label.equals(c.getLabel())).findFirst();
        if (result.isPresent()) return result;
        return deviceConfigService.findByLabel(label);
    }

    @Override
    public List<DeviceConfig> findAll() {
        List<DeviceConfig> configs = deviceConfigService.findAll();
        configs.forEach(c -> configMaps.put(c.getId(), c));
        return configs.stream().map(this::fullCopy).collect(Collectors.toList());
    }

    public DeviceConfig fullCopy(DeviceConfig deviceConfig) {
        //TODO full copy object
        return deviceConfig;
    }
}

package ru.darvell.gb.patterns.service;

import ru.darvell.gb.patterns.domain.DeviceConfig;

import java.util.List;
import java.util.Optional;

public interface DeviceConfigService {
    DeviceConfig saveAndFlush(DeviceConfig deviceConfig);
    Optional<DeviceConfig> findById(long id);
    Optional<DeviceConfig> findByLabel(String label);
    List<DeviceConfig> findAll();
}

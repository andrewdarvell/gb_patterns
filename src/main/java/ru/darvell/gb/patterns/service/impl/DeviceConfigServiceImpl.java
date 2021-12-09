package ru.darvell.gb.patterns.service.impl;

import ru.darvell.gb.patterns.domain.DeviceConfig;
import ru.darvell.gb.patterns.service.DeviceConfigService;

import java.util.List;
import java.util.Optional;

public class DeviceConfigServiceImpl implements DeviceConfigService {

    @Override
    public DeviceConfig saveAndFlush(DeviceConfig deviceConfig) {
        return null;
    }

    @Override
    public Optional<DeviceConfig> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DeviceConfig> findByLabel(String label) {
        return Optional.empty();
    }

    @Override
    public List<DeviceConfig> findAll() {
        return null;
    }
}

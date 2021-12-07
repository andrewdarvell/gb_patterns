package ru.darvell.gb.patterns.reading;

import ru.darvell.gb.patterns.device.DeviceData;

public interface DataListener {
    void receiveData(DeviceData deviceData);

    int getId();
}

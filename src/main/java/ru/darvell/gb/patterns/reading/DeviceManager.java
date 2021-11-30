package ru.darvell.gb.patterns.reading;

import ru.darvell.gb.patterns.device.Device;
import ru.darvell.gb.patterns.device.DeviceData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DeviceManager implements DataProducer {

    private final List<Device> devices = new LinkedList<>();
    private final Map<Integer, DataListener> dataListeners = new HashMap<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void readAllData(long startTime, long endTime) {
        devices.forEach(device -> sendToListeners(device.readAchData(startTime, endTime)));
    }

    private void sendToListeners(DeviceData data) {
        dataListeners.values().forEach(l -> l.receiveData(data));
    }


    @Override
    public void subscribe(DataListener dataListener) {
        dataListeners.put(dataListener.getId(), dataListener);
    }

    @Override
    public void unSubscribe(DataListener dataListener) {
        dataListeners.remove(dataListener.getId());
    }
}

package ru.darvell.gb.patterns.reading.processor;

import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.reading.DataListener;
import ru.darvell.gb.patterns.reading.processing.BaseChainHandler;

import java.util.LinkedList;
import java.util.List;

public class MasterServerDataSender extends BaseChainHandler implements DataListener {

    private static int lastId = 0;
    private final int id;

    private final List<DeviceData> buffer = new LinkedList<>();
    private int size;

    public MasterServerDataSender(int size) {
        this.size = size;
        this.id = lastId++;
    }

    @Override
    public void receiveData(DeviceData deviceData) {
        buffer.add(deviceData);
        checkBufferAndDoNext();
    }

    private void checkBufferAndDoNext() {
        if (buffer.size() > size) {
            //some actions to create threads and send to master server
            System.out.println("Send data to server");
            super.handle(new LinkedList<>(buffer));
            buffer.clear();
        }
    }

    @Override
    public int getId() {
        return id;
    }
}

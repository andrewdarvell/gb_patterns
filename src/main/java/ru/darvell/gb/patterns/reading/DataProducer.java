package ru.darvell.gb.patterns.reading;

public interface DataProducer {

    void subscribe(DataListener dataListener);

    void unSubscribe(DataListener dataListener);
}

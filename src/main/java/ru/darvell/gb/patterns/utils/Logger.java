package ru.darvell.gb.patterns.utils;

public class Logger {

    private static final Logger instance = new Logger();

    public void writeDebug(String message) {
        System.out.println(message);
    }

    public static Logger getInstance() {
        return instance;
    }
}

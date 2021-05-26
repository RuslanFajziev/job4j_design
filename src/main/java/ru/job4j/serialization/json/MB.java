package ru.job4j.serialization.json;

public class MB {
    private final boolean serverBoard;
    private final int maxRamSize;
    private final String socket;

    public MB(boolean serverBoard, int maxRamSize, String socket) {
        this.serverBoard = serverBoard;
        this.maxRamSize = maxRamSize;
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "MB{"
                + "serverBoard=" + serverBoard
                + ", maxRamSize=" + maxRamSize
                + ", socket='" + socket + '\''
                + '}';
    }

    public boolean isServerBoard() {
        return serverBoard;
    }

    public int getMaxRamSize() {
        return maxRamSize;
    }

    public String getSocket() {
        return socket;
    }
}

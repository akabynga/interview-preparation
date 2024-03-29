package com.akabynga.multithreading.philosophers;

public class Fork extends BaseFork {
    private boolean availability = true;

    public Fork(int id) {
        super(id);
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean flag) {
        availability = flag;
    }
}
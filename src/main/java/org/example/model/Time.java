package org.example.model;

import java.time.LocalTime;

public enum Time {
    THIRTEEN("13:30"),
    NINETEEN("19:00"),
    TWENTY_ONE("21:30");

    private final LocalTime timeName;

    Time(String timeName) {
        this.timeName = LocalTime.parse(timeName);
    }

    public LocalTime getTimeName() {
        return timeName;
    }
}
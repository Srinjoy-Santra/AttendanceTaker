package com.example.newu.attendancetaker.Activity;

public class StudentBasics
{
    private String roll,name,status;
    private boolean tick;

    public StudentBasics(String roll, String name, String status, boolean tick) {
        this.roll = roll;
        this.name = name;
        this.status = status;
        this.tick = tick;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getTick() {
        return tick;
    }

    public void setTick(boolean tick) {
        this.tick = tick;

        this.status = (tick)?"Present": "Absent";

    }
}

package com.sande.yamldata;

public class Servo {
    String name;
    int min =-100;
    int max =100;
    int standard = 0;
    int number = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Servo{" +
                "name='" + name + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", standard=" + standard +
                ", number=" + number +
                '}';
    }
}

package com.sande.yamldata;

import java.util.Arrays;

public class Cube {

    float pos[]={0,0,0};
    float size[]={1,1,1};
    String name;

    public float[] getPos() {
        return pos;
    }

    public void setPos(float[] pos) {
        this.pos = pos;
    }

    public float[] getSize() {
        return size;
    }

    public void setSize(float[] size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Cube{" +
                "pos=" + Arrays.toString(pos) +
                ", size=" + Arrays.toString(size) +
                ", name='" + name + '\'' +
                '}';
    }
}

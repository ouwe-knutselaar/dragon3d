package com.sande.yamldata;

import java.util.ArrayList;
import java.util.List;

public class DragonConfig {

    private List<Servo> servos = new ArrayList<>();
    private List<Cube> feet=new ArrayList<>();
    private List<Cube> chest=new ArrayList<>();
    private List<Cube> body=new ArrayList<>();
    private List<Cube> tail=new ArrayList<>();
    private List<Cube> wingleft=new ArrayList<>();
    private List<Cube> wingright=new ArrayList<>();
    private List<Cube> head = new ArrayList<>();
    private List<Cube> jaw = new ArrayList<>();

    public List<Cube> getFeet() {
        return feet;
    }

    public void setFeet(List<Cube> feet) {
        this.feet = feet;
    }

    public List<Cube> getBody() {
        return body;
    }

    public void setBody(List<Cube> body) {
        this.body = body;
    }

    public List<Cube> getChest() {
        return chest;
    }

    public void setChest(List<Cube> chest) {
        this.chest = chest;
    }

    public List<Cube> getTail() {
        return tail;
    }

    public void setTail(List<Cube> tail) {
        this.tail = tail;
    }

    public List<Cube> getWingleft() {
        return wingleft;
    }

    public void setWingleft(List<Cube> wingleft) {
        this.wingleft = wingleft;
    }

    public List<Cube> getWingright() {
        return wingright;
    }

    public void setWingright(List<Cube> wingright) {
        this.wingright = wingright;
    }

    public List<Servo> getServos() {
        return servos;
    }

    public void setServos(List<Servo> servos) {
        this.servos = servos;
    }

    public List<Cube> getHead() {
        return head;
    }

    public void setHead(List<Cube> head) {
        this.head = head;
    }

    public List<Cube> getJaw() {
        return jaw;
    }

    public void setJaw(List<Cube> jaw) {
        this.jaw = jaw;
    }

}

package com.sande.tools;

public class Log {

    private String name;

    public Log(String name){
        this.name = name;
    }

    public void info(String msg){
            System.out.println("INFO :"+ name+":"+msg);
    }

    public void error(String msg){
        System.out.println("ERROR:"+ name+":"+msg);
    }
}

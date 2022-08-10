package com.sande.network;

import com.sande.Global;
import com.sande.tools.ControllerEvent;
import com.sande.tools.Log;
import com.sande.yamldata.Servo;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UDPConnector implements Runnable {


    private DatagramSocket serverSocket;
    private int udpPort;
    private Log log = new Log("UDPConnector");
    private boolean running;
    private byte[] buf = new byte[256];
    List<ControllerEvent> controllerEventList = new ArrayList<>();


    public UDPConnector(int udpPort) {

        this.udpPort = udpPort;
        try {
            this.serverSocket = new DatagramSocket(udpPort);
            Thread serverLoop = new Thread(this);
            serverLoop.setName("UDP Server");
            serverLoop.start();
        } catch (SocketException e) {
            e.printStackTrace();
            log.error("No UDP server possible, non fatal");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        log.info("Start UDP Server");
        try {
            running = true;
            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                serverSocket.receive(packet);
                String receivedData = new String(packet.getData());
                packet.getLength();
                log.info("received" + receivedData.substring(0,8));
                int servo=Integer.parseInt(receivedData.substring(1,2));
                int value=Integer.parseInt(receivedData.substring(4,8));
                sendGameEvent(servo,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    log.info("UDP Server loop stopped");

    }

    public void addControllerEvent(ControllerEvent controllerEvent){
        controllerEventList.add(controllerEvent);
    }

    private void sendGameEvent(int servoNumber, int value) {
        log.info("push to global "+servoNumber+" value"+value);
        if(servoNumber==0)Global.eyes=value;
        if(servoNumber==1)Global.nekRrotate=value;
        if(servoNumber==2)Global.jaw=value;
        if(servoNumber==3)Global.tail=value;
        if(servoNumber==4)Global.wingRight=value;
        if(servoNumber==5)Global.wingLeft=value;
        if(servoNumber==6)Global.nekMuscleLeft=value;
        if(servoNumber==7)Global.nekMuscleRight=value;
    }
}

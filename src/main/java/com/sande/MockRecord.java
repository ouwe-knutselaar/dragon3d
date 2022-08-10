package com.sande;

import java.io.IOException;
import java.net.*;

public class MockRecord {

    public static void main(String [] argv){

        MockRecord mockRecord = new MockRecord();
        mockRecord.mockLoop();

    }

    public void mockLoop(){
        int servo = 1;


        while(true){
            for(int servoValue=0;servoValue<2000;servoValue++) {
                sendMessage(String.format("S%02dV%04d", servo, servoValue));
                delay(20);
            }
            for(int servoValue=2000;servoValue>0;servoValue--) {
                sendMessage(String.format("S%02dV%04d", servo, servoValue));
                delay(20);
            }
        }
    }

    public void delay(int delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 3001);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.sande.network;

import com.sande.tools.Log;
import java.io.IOException;
import java.net.*;

public class UDPConnector {


    private DatagramSocket serverSocket;
    private int udpPort;
    private Log log =new Log("UDPConnector");
    private boolean running;
    private byte[] buf = new byte[256];


    public UDPConnector(int udpPort){

        this.udpPort = udpPort;
        try {
            this.serverSocket = new DatagramSocket(udpPort);
        } catch (SocketException e) {
            e.printStackTrace();
            log.error("No UDP server possible, non fatal");
            return;
        }
    }

    private void serverLoop() throws IOException {

        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            serverSocket.receive(packet);
            String receivedData = new String(packet.getData());
            log.info("received"+receivedData);
        }
    }




}

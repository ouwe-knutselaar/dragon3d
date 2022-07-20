package com.sande;

import com.jme3.system.AppSettings;

import javax.swing.*;
import java.awt.*;

public class DragonGUI {

    public static void main(String[] argv) {

        Dragon3d app = new Dragon3d();
        app.setShowSettings(false);
        AppSettings settings = new AppSettings(true);
        settings.put("Width", 1600);
        settings.put("Height", 1000);
        app.setSettings(settings);
        app.startCanvas();

        Canvas context = (Canvas) app.getContext();

        JFrame jFrame = new JFrame();

        JButton jButton = new JButton("test");

        BorderLayout b = new BorderLayout();
        jFrame.setLayout(b);
        jFrame.add(jButton, BorderLayout.SOUTH);

        Canvas c = new Canvas();
        c.setSize(500, 400);
        jFrame.add(context, BorderLayout.CENTER);

        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}

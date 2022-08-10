package com.sande;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.system.AppSettings;
import com.sande.dialog.DragonDialog;
import com.sande.dragon.Dragon;
import com.sande.network.UDPConnector;
import com.sande.tools.Axisses;
import com.sande.yamldata.DragonConfigReader;


public class Dragon3d extends SimpleApplication {

    private Dragon dragon;

    public static void main(String [] argv){
        Dragon3d app=new Dragon3d();
        app.setShowSettings(false);
        AppSettings settings = new AppSettings(true);
        settings.put("Width", 1200);
        settings.put("Height",700);
        app.setSettings(settings);
        app.start();
    }


    public void simpleInitApp() {

        Global.dragonConfigReader = DragonConfigReader.getInstance();

        Global.udpConnector = new UDPConnector(3001);

        Global.assetManager = assetManager;

        DragonDialog dragonDialog = new DragonDialog();
        dragonDialog.startDialog();
        Global.dragonDialog = dragonDialog;
        Global.dragon3d = this;

        flyCam.setMoveSpeed(10f);
        inputManager.setCursorVisible(true);
        flyCam.setDragToRotate(true);
        cam.setLocation(new Vector3f(20,20,20));

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);

        dragon = new Dragon();
        rootNode.attachChild(dragon);
        rootNode.attachChild(new Axisses());
    }

    @Override
    public void simpleUpdate(float tpf){
        Global.dragonDialog.checkVisibility();
        Global.wingLeft+=5;
        dragon.update();
    }

}

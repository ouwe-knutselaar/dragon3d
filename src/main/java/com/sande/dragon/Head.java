package com.sande.dragon;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.sande.Global;
import com.sande.tools.ControllerEvent;
import com.sande.yamldata.Cube;


public class Head extends DragonPart {

    Jaw jaw = new Jaw();

    public Head() {
        super();

        Jaw jaw = new Jaw();

        Global.dragonConfigReader.getHead().forEach(item -> readItem(item));

        for(Cube cube : Global.dragonConfigReader.getBody()){
            if(cube.getName().equals("jaw"))jaw.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
        }

        attachChild(jaw);

        Quaternion jawQuaternion = jaw.getLocalRotation();

        Global.udpConnector.addControllerEvent(new ControllerEvent() {
            @Override
            public void GameEvent(String id, int value) {
                if(id.equals("jaw")){
                    Quaternion temp = jawQuaternion;
                    temp.fromAngleAxis(FastMath.PI*value/4,new Vector3f(1,0,0));
                    jaw.setLocalRotation(temp);
                    Global.dragonDialog.setSlider(6,value);
                }

            }
        });


    }

}

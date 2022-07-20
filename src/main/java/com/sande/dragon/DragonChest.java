package com.sande.dragon;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.sande.Global;
import com.sande.tools.GameControllerEvent;
import com.sande.yamldata.Cube;
import com.sande.yamldata.DragonConfigReader;


public class DragonChest extends DragonPart {

    public DragonChest(){
        super();

        WingLeft wingLeft = new WingLeft();
        WingRight wingRight = new WingRight();
        Tail tail = new Tail();
        Head head = new Head();
        Node headX = new Node();
        Node headRotate = new Node();


        Global.dragonConfigReader.getChest ().forEach(this::readItem);

        for(Cube cube : Global.dragonConfigReader.getBody()) {
            if(cube.getName().equals("tail"))tail.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
            if(cube.getName().equals("wingleft"))wingLeft.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
            if(cube.getName().equals("wingright"))wingRight.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
            if(cube.getName().equals("head"))headRotate.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
        }


        headX.attachChild(head);
        headRotate.attachChild(headX);
        attachChild(wingLeft);
        attachChild(wingRight);
        attachChild(tail);
        attachChild(headRotate);

        Quaternion tailQuaternion = tail.getLocalRotation();
        Quaternion wingLeftQuaternion = wingLeft.getLocalRotation();
        Quaternion wingRightQuaternion = wingRight.getLocalRotation();
        Quaternion headQuaternion = head.getLocalRotation();
        Quaternion headXQuaternion = headX.getLocalRotation();
        Quaternion headRotateQuaternion = headRotate.getLocalRotation();

        Global.gameControllerService.addGameHandler(new GameControllerEvent() {
            @Override
            public void GameEvent(String id, float value) {
                if(id.equals("ry")){
                    Quaternion temp = wingLeftQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(0,0,1));
                    wingLeft.setLocalRotation(temp);
                    Global.dragonDialog.setSlider(3,value);
                }
                if(id.equals("ry")){
                    Quaternion temp = wingRightQuaternion;
                    temp.fromAngleAxis(+FastMath.PI*value/4,new Vector3f(0,0,1));
                    wingRight.setLocalRotation(temp);
                    Global.dragonDialog.setSlider(4,value);
                }
                if(id.equals("z")){
                    Quaternion temp = headRotateQuaternion;
                    temp.fromAngleAxis(+FastMath.PI*value/4,new Vector3f(0,1,0));
                    headRotate.setLocalRotation(temp);
                    Global.dragonDialog.setSlider(0,value);
                }
                if(id.equals("rx")){
                    Quaternion temp = tailQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(0,1,0));
                    tail.setLocalRotation(temp);
                    Global.dragonDialog.setSlider(5,value);
                }
                if(id.equals("x")){
                    Quaternion temp = headQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(0,0,1));
                    head.setLocalRotation(temp);
                }
                if(id.equals("y")){
                    Quaternion temp = headXQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(1,0,0));
                    headX.setLocalRotation(temp);
                }
            }
        });

    }

}

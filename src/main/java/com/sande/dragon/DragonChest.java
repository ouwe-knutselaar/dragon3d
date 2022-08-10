package com.sande.dragon;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.sande.Global;
import com.sande.tools.ControllerEvent;
import com.sande.tools.Log;
import com.sande.yamldata.Cube;


public class DragonChest extends DragonPart {

    private Log log = new Log("DragonChest");

    private final float SMAX = 4096;
    Quaternion tailQuaternion;
    Quaternion wingLeftQuaternion;
    Quaternion wingRightQuaternion;
    Quaternion headQuaternion;
    Quaternion headXQuaternion;
    Quaternion headRotateQuaternion;

    WingLeft wingLeft = new WingLeft();
    WingRight wingRight = new WingRight();
    Tail tail = new Tail();
    Head head = new Head();
    Node headX = new Node();
    Node headRotate = new Node();

    public DragonChest() {
        super();

        Global.dragonConfigReader.getChest().forEach(this::readItem);

        for (Cube cube : Global.dragonConfigReader.getBody()) {
            if (cube.getName().equals("tail")) tail.move(cube.getPos()[0], cube.getPos()[1], cube.getPos()[2]);
            if (cube.getName().equals("wingleft")) wingLeft.move(cube.getPos()[0], cube.getPos()[1], cube.getPos()[2]);
            if (cube.getName().equals("wingright"))
                wingRight.move(cube.getPos()[0], cube.getPos()[1], cube.getPos()[2]);
            if (cube.getName().equals("head")) headRotate.move(cube.getPos()[0], cube.getPos()[1], cube.getPos()[2]);
        }

        headX.attachChild(head);
        headRotate.attachChild(headX);
        attachChild(wingLeft);
        attachChild(wingRight);
        attachChild(tail);
        attachChild(headRotate);

        tailQuaternion = tail.getLocalRotation();
        wingLeftQuaternion = wingLeft.getLocalRotation();
        wingRightQuaternion = wingRight.getLocalRotation();
        headQuaternion = head.getLocalRotation();
        headXQuaternion = headX.getLocalRotation();
        headRotateQuaternion = headRotate.getLocalRotation();
    }

    public void update() {

        updateWingLeft();
        updateWingRight();

        Quaternion temp = headRotateQuaternion;
        temp.fromAngleAxis(+FastMath.PI * Global.nekRrotate / 4 / SMAX, new Vector3f(0, 1, 0));
        headRotate.setLocalRotation(temp);
        Global.dragonDialog.setSlider(0, Global.nekRrotate);

        temp = tailQuaternion;
        temp.fromAngleAxis(-FastMath.PI * Global.tail / 4 / SMAX, new Vector3f(0, 1, 0));
        tail.setLocalRotation(temp);
        Global.dragonDialog.setSlider(5, Global.tail);

                    /*temp = headQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(0,0,1));
                    head.setLocalRotation(temp);

                    temp = headXQuaternion;
                    temp.fromAngleAxis(-FastMath.PI*value/4,new Vector3f(1,0,0));
                    headX.setLocalRotation(temp);
*/
    }

    private void updateWingRight(){
        if(Global.wingRight < Global.wingRightMin || Global.wingRight > Global.wingRightMax)return;
        log.info("Update "+Global.wingRight);
        Quaternion temp = wingLeftQuaternion;
        temp.fromAngleAxis(-FastMath.PI * Global.wingRight / SMAX, new Vector3f(0, 0, 1));
        wingLeft.setLocalRotation(temp);
        Global.dragonDialog.setSlider(3, Global.wingRight);
    }

    private void updateWingLeft(){
        if(Global.wingLeft < Global.wingLeftMin || Global.wingLeft > Global.wingLeftMax)return;
        log.info("Update "+Global.wingLeft);
        Quaternion temp = wingLeftQuaternion;
        temp.fromAngleAxis(-FastMath.PI * Global.wingLeft / SMAX, new Vector3f(0, 0, 1));
        wingLeft.setLocalRotation(temp);
        Global.dragonDialog.setSlider(3, Global.wingLeft);
    }
};





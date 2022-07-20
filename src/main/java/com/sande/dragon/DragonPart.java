package com.sande.dragon;

import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.sande.Global;
import com.sande.tools.Log;
import com.sande.yamldata.Cube;


public abstract class DragonPart extends Node {

    Log log=new Log("DragonPart");

    Material mat_default;

    public DragonPart(){
        mat_default = new Material(Global.assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
    }

    public void readItem(Cube item) {
        log.info("create "+item);
        Geometry geoBox = DragonGeometry.buildCube(item.getName(),item.getSize()[0],item.getSize()[1],item.getSize()[2]);
        geoBox.move(item.getPos()[0],item.getPos()[1],item.getPos()[2]);
        attachChild(geoBox);
    }
}

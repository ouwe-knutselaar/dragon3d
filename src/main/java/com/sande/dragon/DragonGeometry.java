package com.sande.dragon;

import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.sande.Global;


public class DragonGeometry {

    public static Geometry buildCube(String name,float x,float y,float z){
        Material mat_default = new Material(Global.assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
        Geometry geometry = new Geometry(name,new Box(x/2,y/2,z/2));
        geometry.setMaterial(mat_default);
        geometry.move(x/2,y/2,z/2);
        return geometry;
    }

}

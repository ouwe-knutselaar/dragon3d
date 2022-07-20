package com.sande.tools;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.debug.Arrow;
import com.sande.Global;

public class Axisses extends Node {

    public Axisses(){

        Geometry zarrow = new Geometry("zas",new Arrow(new Vector3f(0.0f, 0.0f, 40f)));
        Material zmat = new Material(Global.assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        zmat.setColor("Color", ColorRGBA.Red);
        zarrow.setMaterial(zmat);
        this.attachChild(zarrow);

        Geometry yarrow = new Geometry("yas",new Arrow(new Vector3f(0.0f, 40, 0.0f)));
        Material ymat = new Material(Global.assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        ymat.setColor("Color", ColorRGBA.Green);
        yarrow.setMaterial(ymat);
        this.attachChild(yarrow);

        Geometry xarrow = new Geometry("xas",new Arrow(new Vector3f(40f, 0.0f, 0.0f)));
        Material xmat = new Material(Global.assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        xmat.setColor("Color", ColorRGBA.Blue);
        xarrow.setMaterial(xmat);
        this.attachChild(xarrow);
    }

}

package com.sande.dragon;

import com.jme3.scene.Node;
import com.sande.Global;
import com.sande.yamldata.Cube;
import com.sande.yamldata.DragonConfigReader;

// The whole dragon
public class Dragon extends Node {

    DragonChest dragonChest;
    Feet feet;

    public Dragon(){
        feet = new Feet();
        dragonChest = new DragonChest();

        for(Cube cube : Global.dragonConfigReader.getBody())
        {
            if(cube.getName().equals("feet"))feet.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
            if(cube.getName().equals("chest"))dragonChest.move(cube.getPos()[0],cube.getPos()[1],cube.getPos()[2]);
        }

        attachChild(feet);
        attachChild(dragonChest);
    }

    public void update(){
        dragonChest.update();
    }

}

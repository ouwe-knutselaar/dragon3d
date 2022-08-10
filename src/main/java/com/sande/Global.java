package com.sande;

import com.jme3.asset.AssetManager;
import com.sande.dialog.DragonDialog;
import com.sande.network.UDPConnector;
import com.sande.yamldata.DragonConfigReader;

import java.util.HashMap;
import java.util.Map;

public class Global {

    public static AssetManager assetManager;
    public static DragonConfigReader dragonConfigReader;
    public static DragonDialog dragonDialog;
    public static Dragon3d dragon3d;

    public static UDPConnector udpConnector;

    public static float nekRrotate=0;
    public static float tail=0;
    public static float jaw=0;

    public static float wingLeft=0;
    public static float wingLeftMin=150;
    public static float wingLeftMax=600;

    public static float wingRight=0;
    public static float wingRightMax=600;
    public static float wingRightMin=150;

    public static float nekMuscleLeft=0;
    public static float nekMuscleRight=0;
    public static float eyes=0;

}

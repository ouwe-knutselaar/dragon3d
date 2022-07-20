package com.sande.dragon;

import com.sande.Global;
import com.sande.yamldata.DragonConfigReader;


public class WingLeft extends DragonPart {

    public WingLeft() {
        super();
        Global.dragonConfigReader.getWingLeft().forEach(item -> readItem(item));

    }
}

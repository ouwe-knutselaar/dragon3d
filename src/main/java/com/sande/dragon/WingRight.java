package com.sande.dragon;

import com.sande.Global;
import com.sande.yamldata.DragonConfigReader;


public class WingRight extends DragonPart {

    public WingRight() {
        super();
        Global.dragonConfigReader.getWingRight().forEach(item -> readItem(item));

    }

}

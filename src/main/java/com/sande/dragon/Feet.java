package com.sande.dragon;

import com.sande.Global;
import com.sande.yamldata.DragonConfigReader;

public class Feet extends DragonPart {

    public Feet(){
        super();
        Global.dragonConfigReader.getFeet().forEach(item -> readItem(item));
    }

}

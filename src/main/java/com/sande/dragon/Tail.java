package com.sande.dragon;

import com.sande.Global;
import com.sande.yamldata.DragonConfigReader;



public class Tail extends DragonPart {

    public Tail() {
        super();
        Global.dragonConfigReader.getTail().forEach(item -> readItem(item));

    }
}

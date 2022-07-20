package com.sande.dragon;

import com.sande.Global;
import com.sande.yamldata.DragonConfigReader;

public class Jaw extends DragonPart {

    public Jaw() {
        super();
        Global.dragonConfigReader.getJaw().forEach(item -> readItem(item));



    }

}

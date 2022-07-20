package com.sande.yamldata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DragonConfigReader {


    private ObjectMapper mapper;
    private DragonConfig dragonConfig;
    private static DragonConfigReader INSTANCE;

    private DragonConfigReader() {
       InputStream ips = getClass().getClassLoader().getResourceAsStream("dragon.yml");
        mapper = new ObjectMapper(new YAMLFactory());
        //mapper.configure(JsonParser.Feature.IGNORE_UNDEFINED,true);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,false);
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            dragonConfig = mapper.readValue(ips,DragonConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static DragonConfigReader getInstance(){
        if(INSTANCE==null)INSTANCE=new DragonConfigReader();
        return INSTANCE;
    }

    public List<Cube> getFeet(){
        return dragonConfig.getFeet();
    }
    public List<Cube> getTail(){
        return dragonConfig.getTail();
    }
    public List<Cube> getBody(){
        return dragonConfig.getBody();
    }
    public List<Cube> getChest(){
        return dragonConfig.getChest();
    }
    public List<Cube> getWingLeft(){ return dragonConfig.getWingleft();}
    public List<Cube> getWingRight(){ return dragonConfig.getWingright();}
    public List<Cube> getHead(){ return dragonConfig.getHead();}
    public List<Cube> getJaw(){ return dragonConfig.getJaw();}
    public List<Servo> getServoList(){return dragonConfig.getServos();}
}

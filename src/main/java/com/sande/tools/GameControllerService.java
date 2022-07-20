package com.sande.tools;

import com.sande.network.UDPConnector;
import net.java.games.input.*;
import java.util.*;

public class GameControllerService {

    Log log = new Log("GameControllerService");

    private  Controller gamepad;
    private List<GameControllerEvent> gameEventHandlers=new ArrayList<>();
    private UDPConnector udpConnector = new UDPConnector(3001);

    public GameControllerService(){
        System.setProperty("jinput.loglevel","FINEST");

        Optional<Controller> gamePadOpt = Arrays.
                asList(ControllerEnvironment.getDefaultEnvironment().getControllers()).stream().
                filter(controller -> controller.
                        getType().
                        equals(Controller.Type.GAMEPAD)).
                findFirst();
        if(gamePadOpt.isPresent())gamepad=gamePadOpt.get();

        //udpConnector.Connect();
    }


    public void processEvents() {
        Event event = new Event();
        if (gamepad.poll()) {
            EventQueue eventQueue = gamepad.getEventQueue();
            while (eventQueue.getNextEvent(event)) {
                //log.info("name "+event.getComponent().getIdentifier().getName()+" -> "+event.getValue());
                gameEventHandlers.forEach(gameEventHandler -> gameEventHandler.GameEvent(event.getComponent().getIdentifier().getName(), event.getValue()));
                //udpConnector.sendUDP("n "+ event.getComponent().getIdentifier().getName() +" "+(int)(1000*event.getValue()));
            }
        }
    }

    public void processRecordedEvent(Map<String, Event> eventList) {
        eventList.forEach((name, event) ->
                gameEventHandlers.forEach(gameEventHandler ->
                        gameEventHandler.GameEvent(event.getComponent().getIdentifier().getName(), event.getValue()))
        );
        eventList.forEach((name,event) -> log.info("record "+name+" "+event.getValue()));
    }

    public void addGameHandler(GameControllerEvent gameControllerEvent) {
        gameEventHandlers.add(gameControllerEvent);
    }


    public void sendEvent(Event event){
        gameEventHandlers.forEach(gameEventHandler -> gameEventHandler.GameEvent(event.getComponent().getIdentifier().getName(), event.getValue()));
    }

}

package com.lib.Manager;

import de.greenrobot.event.EventBus;

/**
 * Created by wangyang on 25/1/18.
 */

public class EventBusManager {
    private static EventBusManager busManager;
    private EventBus eventBus;
    private EventMessage Message=new EventMessage() ;
    private EventBusManager(){
        eventBus=EventBus.getDefault();
    }
    public static EventBusManager getEventBus() {
        if (busManager == null) {
            busManager = new EventBusManager();
        }
        return busManager;
    }
    public void register(Object object){
        eventBus.register(object);
    }
    public void unregister(Object object){
        eventBus.unregister(object);
    }

    public void sendMessage(int msgId, Object object) {
        Message.setMsgId(msgId);
        Message.setObject(object);
        eventBus.post(Message);
    }

}

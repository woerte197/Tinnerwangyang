package com.lib.Manager;

/**
 * Created by wangyang on 25/1/18.
 */

public class EventMessage {
    private int msgId;
    private Object object;

    public EventMessage() {
        super();
    }
    public EventMessage(int msgId, Object object) {
        super();
        this.msgId = msgId;
        this.object = object;
    }
    public int getMsgId() {
        return msgId;
    }
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
}

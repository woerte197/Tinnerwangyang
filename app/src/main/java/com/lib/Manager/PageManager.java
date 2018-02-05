package com.lib.Manager;

import com.example.wangyang.tinnerwangyang.common.MessageCode;

/**
 * Created by wangyang on 25/1/18.
 */

public class PageManager {
    private static PageManager pageManager;
    public static PageManager getPageManager(){
        if (pageManager==null){
            pageManager=new PageManager();
        }
        return pageManager;
    }
    public void push(int resultCode, Object msg) { //初始化各类服务
        EventBusManager.getEventBus().sendMessage(resultCode, msg);
    }
    public void pushLogin(){
        push(MessageCode.RESULT_LOGIN,null);
    }
    public void pushLogout(){
    push(MessageCode.RESULT_LOGOUT,null);
    }
    public void pushDelete(){
        push(MessageCode.ADD_FOOD,null);
    }
}

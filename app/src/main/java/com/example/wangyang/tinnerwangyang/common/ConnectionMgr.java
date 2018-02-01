package com.example.wangyang.tinnerwangyang.common;

/**
 * Created by wangyang on 3/1/18.
 */

import java.net.HttpURLConnection;
import java.util.Map;

import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionMgr {
    private Map<Long, HttpURLConnection> threadConnections = new ConcurrentHashMap<Long, HttpURLConnection>();

    private static ConnectionMgr instance;

    public static ConnectionMgr getInstance() {
        if (instance == null) {
            instance = new ConnectionMgr();
        }
        return instance;
    }

    public void addActiveConnection(HttpURLConnection connection) {

        threadConnections.put(Thread.currentThread().getId(), connection);
    }

    public boolean removeActiveConnection(HttpURLConnection connection) {
        return threadConnections.remove(Thread.currentThread().getId()) == null ? false : true;
    }

    public HttpURLConnection getLocalThreadHttpURLConnection(long threadId) {
        return threadConnections.get(threadId);
    }
}

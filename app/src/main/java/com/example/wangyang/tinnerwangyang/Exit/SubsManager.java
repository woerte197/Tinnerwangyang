package com.example.wangyang.tinnerwangyang.Exit;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by wangyang on 29/12/17.
 */

public class SubsManager {
    private static List<Subscription> subscriptions;

    public static void add(Subscription s) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
            if (s != null) {
                subscriptions.add(s);
            }
        }
        if (s != null) {
            subscriptions.add(s);
        }
    }
}

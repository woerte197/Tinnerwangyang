package com.lib.Manager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import com.example.wangyang.tinnerwangyang.Pedometer.StepService;

import java.util.List;

/**
 * Created by wangyang on 8/2/18.
 */

public class PedometerManager {
    private static PedometerManager pedometerManager;

    public static PedometerManager getPedometerManager() {
        if (pedometerManager == null) {
            synchronized (PedometerManager.class) {
                pedometerManager = new PedometerManager();
            }

        }
        return pedometerManager;
    }

    public void startServiceForStrategy(Context context, ServiceConnection coon) {
        if (!isServiceWork(context, StepService.class.getName())) {
            setupService(context, true, coon);
        } else {
            setupService(context, false, coon);
        }
    }

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
    public boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(40);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }

    private void setupService(Context context, boolean flag, ServiceConnection conn) {
        Intent intent = new Intent(context, StepService.class);
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
        if (flag) {
            context.startService(intent);
        }
    }

}

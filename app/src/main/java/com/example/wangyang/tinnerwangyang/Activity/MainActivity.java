package com.example.wangyang.tinnerwangyang.Activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangyang.tinnerwangyang.Pedometer.Constant;
import com.example.wangyang.tinnerwangyang.Pedometer.StepService;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.TabBean;
import com.example.wangyang.tinnerwangyang.ViewUtils;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.common.Setting;
import com.example.wangyang.tinnerwangyang.databinding.ActivityMainBinding;
import com.example.wangyang.tinnerwangyang.fragement.TabHomeFragment;
import com.example.wangyang.tinnerwangyang.fragement.TabUserFragment;
import com.example.wangyang.tinnerwangyang.fragement.TinnerSportsFragment;
import com.lib.Manager.FileUtils;
import com.lib.Manager.PedometerManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Handler.Callback {

    private TabBean tab0 = new TabBean(R.drawable.ic_cheep_default, R.drawable.ic_cheep_selected, true, new TabHomeFragment());
    private TabBean tab1 = new TabBean(R.drawable.ic_class_default, R.drawable.ic_class_selected, false, new TinnerSportsFragment());
    private TabBean tab2 = new TabBean(R.drawable.ic_message_default, R.drawable.ic_message_selected, false, new TabUserFragment());
    private List<TabBean> tabs = new ArrayList<>();
    ActivityMainBinding binding;
    private long first_time;
    private long TIME_INTERVAL = 500;
    private Messenger messenger;
    private Messenger mGetReplyMessenger = new Messenger(new Handler(this));
    private int value;

    public static int getTextstep() {
        return textstep;
    }

    public static void setTextstep(int textstep) {
        MainActivity.textstep = textstep;
    }

    private Handler delayHandler;
    private static int textstep;

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case Constant.MSG_FROM_SERVER:
                //    更新界面上的步数
                textstep = msg.getData().getInt("step");
                setTextstep(textstep);
                delayHandler.sendEmptyMessageDelayed(Constant.REQUEST_SERVER, TIME_INTERVAL);
                break;
            case Constant.REQUEST_SERVER:
                try {
                    Message msg1 = Message.obtain(null, Constant.MSG_FROM_CLIENT);
                    msg1.replyTo = mGetReplyMessenger;
                    messenger.send(msg1);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTabs(tabs);
        binding.setContext(this);
        value = getIntent().getIntExtra(Setting.TABUSERFRAGMENT, 1);
        initTab();
        initPedometer();
        PedometerManager.getPedometerManager().startServiceForStrategy(this, conn);
        FileUtils.getKnowledgesData();

    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                messenger = new Messenger(service);
                Message msg = Message.obtain(null, Constant.MSG_FROM_CLIENT);
                msg.replyTo = mGetReplyMessenger;
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void initPedometer() {
        delayHandler = new Handler(this);
    }

    private void initTab() {
        tabs.add(tab0);
        tabs.add(tab1);
        tabs.add(tab2);
        for (TabBean tab : tabs) {
            addFragment(R.id.fragmentContainer, tab.getFragment(), false);
            tab.setTabListener(t -> resetFragment(t));
        }
        if (value == 3) {
            resetFragment(tab2);
        }
        setCurrentFragment();//设置当前Fragement
    }

    public void resetFragment(TabBean t) {
        for (TabBean tab : tabs) {
            tab.setSelected(false);
        }
        t.setSelected(true);
        setCurrentFragment();
    }

    public void setCurrentFragment() {
        for (TabBean tab : tabs) {
            if (tab.isSelected()) {
                showFragmentTab(tab.getFragment());
                tab.getFragment().onTabSelected();
            } else {
                hideFragmentTab(tab.getFragment());
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondtime = System.currentTimeMillis();
                if (secondtime - first_time > Setting.SIZE_MAX_PRESS_TIME) {
                    ViewUtils.showMessage("再按一次退出应用");
                    first_time = secondtime;
                    return true;
                } else {
                    return super.onKeyDown(keyCode, event);
                }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
//        moveTaskToBack(true);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        unbindService(conn);
        super.onDestroy();
    }

    @Override
    public void update(int msg, Object args) {
        super.update(msg, args);
        switch (msg) {
            case MessageCode.RESULT_LOGIN:
                resetFragment(tab2);
                break;


        }
    }
}

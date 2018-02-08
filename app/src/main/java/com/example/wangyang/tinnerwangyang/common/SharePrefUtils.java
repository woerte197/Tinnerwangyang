package com.example.wangyang.tinnerwangyang.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.google.gson.JsonSyntaxException;


import java.util.ArrayList;
import java.util.List;

public class SharePrefUtils {
    private static final String TAG = "SharePrefUtils";
    private long autoId = 0;
    private Editor editor;
    private SharedPreferences share;
    private static SharePrefUtils instance = null;

    private SharePrefUtils() {
        share = ECKit.getApp().getSharedPreferences(Setting.PREFS_NAME, Context.MODE_PRIVATE);
        editor = share.edit();
    }

    public static SharePrefUtils getInstance() {
        if (instance == null) {
            instance = new SharePrefUtils();
        }
        return instance;
    }

    public void setOtherNick(String userId, String nickName) {
        editor.putString(Setting.DBFIELD_OTHER_NICK + userId, nickName);
        editor.commit();

    }

    public void setWeight(String weight, String time) {
        editor.putString("weight", weight);
        editor.putString("time", time);
        editor.commit();
    }

    public String getWeightweight() {
        return share.getString("weight", "");
    }

    public String getWeighttime() {
        return share.getString("time", "");
    }

    public void setMyBean(String values) {
        editor.putString(Setting.MYBEAN, values);
        editor.commit();
    }

    public String getMyBean() {
        return share.getString(Setting.MYBEAN, "");
    }

    public String getOtherNick(String userId) {
        return share.getString(Setting.DBFIELD_OTHER_NICK + userId, "");
    }

    public void setOtherImage(String userId, String imgUrl) {
        editor.putString(Setting.DBFIELD_OTHER_IMG + userId, imgUrl);
        editor.commit();
    }

    public String getOtherImg(String userId) {
        return share.getString(Setting.DBFIELD_OTHER_IMG + userId, "");
    }

    public void setUmengToken(String umengToken) {
        editor.putString(Setting.DBFIELD_UMTOKEN, umengToken);
        editor.commit();
    }

    public String getUmengToken() {
        return share.getString(Setting.DBFIELD_UMTOKEN, " -1");
    }

    public void setXmToken(String xMtoken) {
        editor.putString(Setting.DBFIELD_XMTOKEN, xMtoken);
        editor.commit();
    }

    public String getXmToken() {
        return share.getString(Setting.DBFIELD_XMTOKEN, "-1");
    }

    public void setHuaWeiToken(String hWtoken) {
        editor.putString(Setting.DBFIELD_HWTOKEN, hWtoken);
        editor.commit();
    }

    public String getHuaWeiToken() {
        return share.getString(Setting.DBFIELD_HWTOKEN, "-1");
    }

    public void setXmUnread(int count) {
        editor.putInt(Setting.DBFIELD_XMUNREAD, count);
        editor.commit();
    }

    public int getXmRead() {
        int count = share.getInt(Setting.DBFIELD_XMUNREAD, 0);
        return count;
    }

    public void setNewsUnRead(int count) {
        editor.putInt(Setting.DBFIELD_NEWS, count);
        editor.commit();

    }

    public int getNewsUnRead() {
        int count = share.getInt(Setting.DBFIELD_NEWS, 0);
        return count;
    }

    public void setActiveUnRead(int count) {
        editor.putInt(Setting.DBFIELD_ACTIVE, count);
        editor.commit();

    }

    public int getActiveUnRead() {
        int count = share.getInt(Setting.DBFIELD_ACTIVE, 0);
        return count;
    }

    public String getLoginUserId() {
        String userName = share.getString(Setting.DBFIELD_USERID, "");
        return userName;
    }

    public int getLogintype() {
        int logintype = share.getInt(Setting.LOGIN_TYPE, 0);
        return logintype;
    }

    /**
     * userId置为-1
     *
     * @param username
     */
    public void setLoginUserName(String username, int type) {
        editor.putInt(Setting.LOGIN_TYPE, type);
        editor.putString(Setting.DBFIELD_USERID, username);
        editor.commit();
    }

    public long getAutoId() {
        autoId = share.getLong(Setting.DBFIELD_AUTOID, 0);
        editor.putLong(Setting.DBFIELD_AUTOID, ++autoId);
        editor.commit();
        return autoId;
    }

    public void setShowSound(boolean f) {
        editor.putBoolean(Setting.DBFIELD_SHOWSOUND, f);
        editor.commit();
    }

    public boolean getShowSound() {
        return share.getBoolean(Setting.DBFIELD_SHOWSOUND, true);
    }

    public void setShowVibrate(boolean f) {
        editor.putBoolean(Setting.DBFIELD_VIBRATE, f);
        editor.commit();
    }

    public boolean getShowVibrate() {
        return share.getBoolean(Setting.DBFIELD_VIBRATE, true);
    }

    public void setShowNotification(boolean f) {
        editor.putBoolean(Setting.DBFIELD_SHOWNOTICATION, f);
        editor.commit();
    }

    public boolean getShowNotification() {
        return share.getBoolean(Setting.DBFIELD_SHOWNOTICATION, true);
    }

    public void setToken(String token) {
        editor.putString(Setting.DBFIELD_TOKEN, token);
        editor.commit();
    }

    public String getToken() {
        return share.getString(Setting.DBFIELD_TOKEN, "");
    }

    public boolean isLogin() {
        String userId = getLoginUserId();
        if (!TextUtils.isEmpty(userId) && !"-1".equals(userId)) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        editor.clear();
        editor.commit();

    }

//    public int getDefKeyBoardChatHeight() {
//        return share.getInt(Setting.DEF_KEYBOARD_CHAT_HEIGHT, SoftKeyboardManager.softInputHeight());
//    }

    public void setDefKeyBoardChatHeight(int height) {
        editor.putInt(Setting.DEF_KEYBOARD_CHAT_HEIGHT, height);
        editor.commit();
    }

    /**
     * 设置用户名
     *
     * @param pn
     */
    public void setUserPN(String pn) {
        editor.putString(Setting.DBFIELD_USERPN, pn);
        editor.commit();
    }

    public String getUserPN() {
        return share.getString(Setting.DBFIELD_USERPN, "");
    }

    public void setString(String key, String val) {
        editor.putString(key, val);
        editor.commit();
    }

    public String getString(String key) {
        return share.getString(key, "");
    }

    public void setHasShowClouldDialog(boolean show) {
        editor.putBoolean(Setting.DBFIELD_SHOW_CLOULD_DIALOG, show);
        editor.commit();
    }

//    public void setChoiceSelectNation(Block block) {
//        String g = Constant.GSON.toJson(block);
//        editor.putString(Setting.DBFIELD_CHOCIE_BLOCKID, g);
//        editor.commit();
//    }
//
//    public Block getChoiceSelectNation() {
//        String g = share.getString(Setting.DBFIELD_CHOCIE_BLOCKID, "");
//        return Constant.GSON.fromJson(g, Block.class);
//
//    }
//
//    public void setSelectNation(Nation nation) {
//        String g = Constant.GSON.toJson(nation);
//        editor.putString(Setting.DBFIELD_DEFAULT_SELECT_NATION, g);
//        editor.commit();
//    }
//
//    public Nation getSelectNation() {
//        String g = share.getString(Setting.DBFIELD_DEFAULT_SELECT_NATION, "");
//        return Constant.GSON.fromJson(g, Nation.class);
//    }

    public boolean getHasShowClouldDialog() {
        return share.getBoolean(Setting.DBFIELD_SHOW_CLOULD_DIALOG, false);
    }

    public int getDownloadProcess() {
        return share.getInt(Setting.DBFIELD_DOWNLOADPROCESS, 0);
    }

    public void setDownloadProcess(int process) {
        editor.putInt(Setting.DBFIELD_DOWNLOADPROCESS, process);
        editor.commit();
    }

    public void setweight(String s) {
        editor.putString(Setting.DBFIELD_WEIGHT, s);
        editor.commit();
    }

    public String getWeight() {
        return share.getString(Setting.DBFIELD_WEIGHT, "");
    }

//    public void addLiveRoomGroupIds(String gId) {
//        List<String> data = getLiveRoomGroupIds();
//        if (data == null) {
//            data = new ArrayList<String>();
//        }
//        if (!TextUtils.isEmpty(gId)) {
//            data.add(gId);
//        }
//        editor.putString(Setting.DBFIELD_LIVE_ROOM_GROUPID_SET, Constant.GSON.toJson(data));
//        editor.commit();
//    }

//    public List<String> getLiveRoomGroupIds() {
//        String values = share.getString(Setting.DBFIELD_LIVE_ROOM_GROUPID_SET, "");
//        return Constant.GSON.fromJson(values, Constant.TYPE_LIST_STRING);
//    }
//
//    public void setCrmMenuQQ(String json) {
//        editor.putString(Setting.CONFIG_PARA_CRM_MENU_QQ, json);
//        editor.commit();
//    }
//
//    public void setSearchKeywords(List<SearchItem> items) {
//        editor.putString("searchKeywords", Constant.GSON.toJson(items));
//        editor.commit();
//    }
//
//    public List<SearchItem> getSearchKeywords() {
//        String json = share.getString("searchKeywords", Constant.GSON.toJson(new ArrayList<>()));
//        return Constant.GSON.fromJson(json, Constant.TYPE_LIST_SEARCH_ITEM);
//    }
//
//    public void setMainPage(String keys, List<Article> articles) {
//        try {
//            editor.putString(keys, Constant.GSON.toJson(articles)).commit();
//        } catch (Exception e) {
//            System.out.print("");
//        }
//
//    }
//
//    public List<Article> getMianPage(String keys) {
//        String json = share.getString(keys, Constant.GSON.toJson(new ArrayList<>()));
//        Log.i(TAG, "getMianPage: " + json);
//        return Constant.GSON.fromJson(json, Constant.TYPE_LIST_ARTICLE_ITEM);
//    }
//
//    public CrmMenu getCrmMenuQQ() {
//        try {
//            String data = share.getString(Setting.CONFIG_PARA_CRM_MENU_QQ, "");
//            Result<CrmMenu> result = Constant.GSON.fromJson(data, Constant.TYPE_RESULT_CRMMENU);
//            return result.getData();
//        } catch (JsonSyntaxException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}

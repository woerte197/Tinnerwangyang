package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

/**
 * Created by wangyang on 23/1/18.
 */

public class TodayItem implements Wachter {
    private static final String TYPE = "TabUserItem";
    private String title;
    private boolean showMsg;
    private boolean isHeader;
    private String count;
    private int jumperType;
    private boolean needSpace;
    private boolean isVersion;
    private int iconId;
    private boolean isLogIn = true;
    @Override
    public String toString() {
        return "MyItem{" +
                "title='" + title + '\'' +
                ", showMsg=" + showMsg +
                ", isHeader=" + isHeader +
                ", count='" + count + '\'' +
                ", jumperType=" + jumperType +
                ", needSpace=" + needSpace +
                ", isVersion=" + isVersion +
                ", iconId=" + iconId +
                ", isLogIn=" + isLogIn +
                '}';
    }
    public TodayItem(String title, boolean showMsg, boolean needSpace, int iconId, int jumperType){
        this.title=title;
        this.showMsg=showMsg;
        this.needSpace=needSpace;
        this.iconId=iconId;
        this.jumperType=jumperType;
    }
    public static String getTYPE() {
        return TYPE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowMsg() {
        return showMsg;
    }

    public void setShowMsg(boolean showMsg) {
        this.showMsg = showMsg;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getJumperType() {
        return jumperType;
    }

    public void setJumperType(int jumperType) {
        this.jumperType = jumperType;
    }

    public boolean isNeedSpace() {
        return needSpace;
    }

    public void setNeedSpace(boolean needSpace) {
        this.needSpace = needSpace;
    }

    public boolean isVersion() {
        return isVersion;
    }

    public void setVersion(boolean version) {
        isVersion = version;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }


    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return null;
    }
}

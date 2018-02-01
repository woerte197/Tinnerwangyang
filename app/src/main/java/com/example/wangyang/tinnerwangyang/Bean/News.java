package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 3/1/18.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wangyang.tinnerwangyang.BR;
import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

public class News extends BaseObservable implements Wachter {
    public static final String TYPE = "News";
    private int column = 1; //1代表1列 2代表2列
    private int item;
    private String activeTime;
    private boolean isEnd;
    private int newsType;
    private String beginTime;
    private String endTime;
    private String title;
    private String articleId;
    private String userId;
    private String readCount;
    private String shortContent;
    private String advertUrl;
    private long createTime;
    private String articleUrl;
    private int isActivity;
    private boolean isCollection;
    private boolean isCheck;
    private boolean expand;
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String content;
    private String img;
    private String url;


    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public boolean getEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemType() {
        return type;
    }

    @Bindable
    public boolean isCheck() {
        return isCheck;

    }

    public void setCheck(boolean check) {
        isCheck = check;
        notifyPropertyChanged(BR.check);
    }

    @Bindable
    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
        notifyPropertyChanged(BR.expand);
    }

    public News(int column, int item, String title, String articleId, String userId, String readCount, String shortContent, String advertUrl, long createTime, String articleUrl, int isActivity, boolean isCollection) {
        this.column = column;
        this.item = item;
        this.title = title;
        this.articleId = articleId;
        this.userId = userId;
        this.readCount = readCount;
        this.shortContent = shortContent;
        this.advertUrl = advertUrl;
        this.createTime = createTime;
        this.articleUrl = articleUrl;
        this.isActivity = isActivity;
        this.isCollection = isCollection;
    }

    public News() {
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Bindable
    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
        notifyPropertyChanged(BR.readCount);

    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public int getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(int isActivity) {
        this.isActivity = isActivity;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return TYPE;
    }


    public int getColumn() {
        return 1;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public enum Item {
        LEFT, RIGHT
    }
}

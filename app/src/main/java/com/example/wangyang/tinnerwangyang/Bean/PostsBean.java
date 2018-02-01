package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wangyang on 18/1/18.
 */

public class PostsBean implements Wachter {
    /**
     * id : 43756332
     * body : #我问NICE# 第126期：
     *
     * @传说中的九公子 #我问NICE# 运动后是不饿的，但是都说疲劳下应该补充食物，否则消耗的不是脂肪，而且肌肉！！！那么我到底该不该运动后喝牛奶或者蛋白质粉？
     * <p>
     * ----我是回答的分割线----
     * <p>
     * NICE顾问Anna：
     * 这个问题根据情况不同，我们有不同的解决措施。基数较大者不建议运动后补充能量及营养，以免阻碍脂肪燃烧进度。塑型者看运动形式，运动如果是中强度有氧，如慢跑30分钟，无需额外进食；如果是高强度的肌肉训练，建议运动后摄入脱脂牛奶200-300ml即可；对于男生追求肌肉的话，处理方式更加不同，运动前后都需要保证蛋白质的摄入。
     * <p>
     * 至于你提到的那个说法：“疲劳下应该补充食物，否则消耗的不是脂肪，而且肌肉！”  想要肌肉消耗供能，那要看运动强度、肌肉训练方式和运动总消耗，一般来说大家的运动量还不足以达到消耗肌肉供能的情况，咱们又不是专业运动员也不是健美运动员哦~ 跳个30分钟的hiit就不用想着消耗肌肉了。
     * <p>
     * created_at : 2018-01-18T11:24:35.656+08:00
     * type : null
     * has_suggestion : false
     * private : false
     * own : false
     * photos : []
     * user : {"id":13852824,"nickname":"NICE服务","avatar_url":"http://one.boohee.cn/t/2016/10/13/66F05760-5A51-4BC5-8327-69CEE317474C.jpg?imageView/1/w/120/h/120","title":"","light":false}
     * cut : false
     * share_url : http://status.boohee.com//posts/eo3koFZWm_Gf3j4jqhbTYucxMFBRD-4IXfZLksb_X48=.html
     * feedback : null
     * envious_count : 31
     * comment_count : 0
     * reposted : false
     * favorite : false
     * attachments : {"type":"video","title":"#太阳猫美食TV# 佛系养生粥底火锅，连锅都舔干净了！","pic":"http://image.pearvideo.com/main/20180117/10699136-181054-0.png","url":"http://video.pearvideo.com/mp4/third/20180117/10699136_180220-fhd.mp4","cover":"http://image.pearvideo.com/main/20180117/10699136-181054-0.png"}
     */

    private int id;
    private String body;
    private String created_at;
    private Object type;
    private boolean has_suggestion;
    @SerializedName("private")
    private boolean privateX;
    private boolean own;

    private List<Photos> photos;
    private UserBean user;
    private boolean cut;

    private String share_url;
    private boolean favorite;
    private AttachmentsBean attachments;
    private Object feedback;
    private int envious_count;
    private int comment_count;
    private boolean reposted;
    private int fav_count;


    @Override
    public String toString() {
        return "PostsBean{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", created_at='" + created_at + '\'' +
                ", type=" + type +
                ", has_suggestion=" + has_suggestion +
                ", privateX=" + privateX +
                ", own=" + own +
                ", photos=" + photos +
                ", user=" + user +
                ", cut=" + cut +
                ", share_url='" + share_url + '\'' +
                ", favorite=" + favorite +
                ", attachments=" + attachments +
                ", feedback=" + feedback +
                ", envious_count=" + envious_count +
                ", comment_count=" + comment_count +
                ", reposted=" + reposted +
                ", fav_count=" + fav_count +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String getType() {
        return null;
    }

    public Object gettype() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public boolean isHas_suggestion() {
        return has_suggestion;
    }

    public void setHas_suggestion(boolean has_suggestion) {
        this.has_suggestion = has_suggestion;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    public boolean isOwn() {
        return own;
    }

    public void setOwn(boolean own) {
        this.own = own;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public boolean isCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getFeedback() {
        return feedback;
    }

    public void setFeedback(Object feedback) {
        this.feedback = feedback;
    }

    public int getEnvious_count() {
        return envious_count;
    }

    public void setEnvious_count(int envious_count) {
        this.envious_count = envious_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isReposted() {
        return reposted;
    }

    public void setReposted(boolean reposted) {
        this.reposted = reposted;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public AttachmentsBean getAttachments() {
        return attachments;
    }

    public void setAttachments(AttachmentsBean attachments) {
        this.attachments = attachments;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }
    public int getFav_count() {
        return fav_count;
    }

    public void setFav_count(int fav_count) {
        this.fav_count = fav_count;
    }
}

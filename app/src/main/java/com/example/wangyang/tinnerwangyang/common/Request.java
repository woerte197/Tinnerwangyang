package com.example.wangyang.tinnerwangyang.common;


import android.util.Log;

import com.example.wangyang.tinnerwangyang.Bean.PageRequest;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.Exit.MD5Util;
import com.example.wangyang.tinnerwangyang.URLSetting;
import com.example.wangyang.tinnerwangyang.common.FormFile;
import com.example.wangyang.tinnerwangyang.common.RequestMethod;
import com.example.wangyang.tinnerwangyang.common.Setting;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.wangyang.tinnerwangyang.common.RequestMethod.HTTP_GET;
import static com.example.wangyang.tinnerwangyang.common.RequestMethod.HTTP_POST;


public class Request {
    private static final String TAG = "Request";
    private long id;
    private Type type;                                  //转换类型
    private Class cls;
    //        private G g = new G();                              //全局参数
    private String baseUrl;                            //url前缀
    private FormFile[] files;
    private PageRequest pager;
    private String privateKey;
    private String requestName;
    private boolean withCache = false;                  // 是否需要缓存
    private Map<String, Object> params;                    //存放参数的map
    private Map<String, String> headers;

    private RequestMethod http_type = HTTP_POST;        //默认是post请求

    public Request() {
        params = new HashMap<>();
        headers = new HashMap<>();
        pager = new PageRequest(0, Setting.SIZE_PAGE);
    }

    public Request(String u) {
        this(u, null, null);
    }

    public Request(int id, String urlName, Type type, String url) {
        this.id = id;
        requestName = urlName;
        this.type = type;
        params = new HashMap<>();
        //   files = new FormFile[]{};
        headers = new HashMap<>();
        baseUrl = url;
        pager = new PageRequest(0, Setting.SIZE_PAGE);
    }

    public Request(String urlName, Type type, String baseurl) {
        this(0, urlName, type, baseurl);
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public Request addPager(int start, int size) {
        addStartIndexParam(start);
        addPageSizeParam(size);
        return this;
    }

    public PageRequest getPager() {
        return pager;
    }

    public boolean isFirstPage() {

        return getPager().getStart() == 0;
    }


    public void updateRequestStart(int start, List data) {
        pager.setStart(start + (data == null ? 0 : data.size()));
        addStartIndexParam(pager.getStart());
        addPageSizeParam(pager.getPageSize());
        addPage(pager.getStart() / pager.getPageSize());
    }

    public void updateRequestStart(List data) {
        if (data == null) {
            pager.setStart(0);
        }
        updateRequestStart(pager.getStart(), data);
        Log.i("ssssssssssssss", String.valueOf(pager.getStart()));
    }

    public void updateRequest(List data) {
        if (data == null) {
            pager.setStart(0);
            pager.setPage(0);
        } else {
            pager.setStart(1);
            int page = pager.getPage();
            page++;
            pager.setPage(page);
        }
        addPageSizeParam(pager.getPageSize());
        addStartIndexParam(pager.getStart());
        addPage(pager.getPage());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isWithCache() {
        return withCache;
    }

    public String getName() {
        return requestName + getId();
    }

    public void removeParam(String key) {
        params.remove(key);
    }

    public void removeUserIdParam() {
        removeParam("userId");
    }

    public Request addParam(String key, Object value) {
        if (value != null) {
            params.put(key, value);
        }
        return this;
    }

    public void addParams(Object o) {
        addParam("params", o);
    }

    public void addPage(Object value) {
        addParam("page", value);
    }

    public void addMajorClassId(Object value) {
        addParam("majorClassId", value);
    }

    public void addRankId(Object value) {
        addParam("rankId", value);
    }


    public void addCatId(Object value) {
        addParam("catId", value);
    }

    public void addKeyWord(Object value) {
        addParam("keyword", value);
    }

    public void addCountry(Object value) {
        addParam("country", value);
    }

    public void addTagId(Object value) {
        addParam("tagId", value);
    }

    public void addGroupId(Object value) {
        addParam("hxGroupId", value);
    }

    public void addLiveIdParam(Object value) {
        addParam("liveId", value);
    }

    public void addFlagParam(Object value) {
        addParam("flag", value);
    }

    public void addUmengChannelParam() {
        addParam("umengChannel", StringUtils.getUMENG_CHANNEL_MetaValue());
    }

    public void addinviteCodeParam(Object value) {
        addParam("inviteCode", value);
    }

    public void addStartIndexParam(Object value) {
        addParam("startIndex", value);

    }

    public void addPageSizeParam(Object value) {
        addParam("pageSize", value);
    }

    public void addUserIdParam() {
        if (SharePrefUtils.getInstance().isLogin()) {
            addParam("userId", SharePrefUtils.getInstance().getLoginUserId());
        }
    }

    public void addUserIdNoneParam(Object userId) {
        addParam("userId", userId);
    }

    public void addQSIdParam(Object qsId) {
        addParam("qsId", qsId);
    }

    public void addSIdParam(Object qsId) {
        addParam("sId", qsId);
    }

    public void addMsgIdParam(Object value) {
        addParam("msgId", value);
    }

    public void addAuthorIdParam(Object value) {
        addParam("authorId", value);
    }

    public void addFriendIdParam(Object value) {
        addParam("friendId", value);
    }

    public void addFriendIdParamNotLogin(Object value) {
        addParam("friendId", value);
    }

    public void addOrderId(Object value) {
        addParam("orderId", value);
    }

    public void addBlockIdParam(Object value) {
        addParam("blockId", value);
    }

    public void addTitleParam(Object value) {
        addParam("title", value);
    }

    public void addContentParam(Object value) {
        addParam("content", value);
    }

    public void addContentIdParam(Object value) {
        addParam("contentId", value);
    }

    public void addArticleIdParam(Object value) {
        addParam("articleId", value);
    }

    public void addArticleIdsParam(Object value) {
        addParam("articleIds", value);
    }

    public void addPictureCountParam(Object value) {
        addParam("pictureCount", value);
    }

    public void addPictureId(Object value) {
        addParam("pictureId", value);
    }

    public void addPhoneNumParam(Object value) {
        addParam("phoneNum", value);
    }

    public void addUserNameParam(Object value) {
        addParam("username", value);
    }

    public void addPasswordParam(Object value) {
        addParam("password", value);
    }
//
//    public void addDeviceIdParam() {
//        addParam("deviceId", SystemUtils.getDeviceId());
//    }

    public void addTypeParam(Object value) {
        addParam("type", value);
    }

    public void addRegisterActionParam(Object value) {
        addParam("fromPath", value);
    }

    public void addCaptchaParam(Object value) {
        addParam("captcha", value);
    }

    public void addIdsParam(Object value) {
        addParam("ids", value);
    }

    public void addIdParam(Object value) {
        addParam("id", value);
    }

    public void addReplyUserIdParam(Object value) {
        addParam("d_replyUserId", value);
    }

    public void addPersonIdParam(Object value) {
        addParam("personId", value);
    }

    public void addKeywordsParam(Object value) {
        addParam("keywords", value == null ? "" : value);
    }

    public void addOrderParam(Object value) {
        addParam("timeOrder", value);
    }

    public void addOrderMoreNewParam() {
        addOrderParam(1);
    }

    public void addOrderHotParam() {
        addOrderParam(2);
    }

    public void addNickNameParam(Object value) {
        addParam("nickName", value == null ? "" : value);
    }

//    public String getNickNameParam() {
//        return getParams("nickName") == null ? null : getParams("nickName") + "";
//    }

    public void addParentIdParam(Object value) {
        addParam("parentId", value);
    }

    public void addAreaCodeParam(Object value) {
        addParam("areaCode", value);
    }

    public void addVersionCodeParam(String value) {
        addParam("versionCode", value);
    }

    public void addSearchTypeParam(String value) {
        addParam("searchType", value);
    }

    public void addNationIdParam(Object value) {
        addParam("nationId", value);
    }

    public void addCrmNationIdParam(Object value) {
        addParam("crmNationId", value);
    }

    public void addRid(Object value) {
        addParam("rid", value);
    }

    public void addSearchAnswerTypeParam() {
        addSearchTypeParam("2");
    }

    public void addSearchArticleTypeParam() {
        addSearchTypeParam("3");
    }

    public void addSearchSystemTypeParam() {
        addSearchTypeParam("4");
    }

    public void addSearchAllTypeParam() {
        addSearchTypeParam("1");
    }

    public void addSearchNationTypeParam() {
        addSearchTypeParam("5");
    }

//    public void addWechatParam(Bundle bundle) {
//        addParam("appid", EncryptKey.getWxLogId());
//        addParam("secret", EncryptKey.getWechatScreetMetaValue());
//        if (bundle != null) {
//            addParam("code", bundle.getString("_wxapi_sendauth_resp_token"));
//        }
//        addParam("grant_type", "authorization_code");
//    }

    public void addWechat2Param(String token, String openid) {
        addParam("access_token", token);
        addOpenIdParam(openid);
    }

    public void addOpenIdParam(String openid) {
        addParam("openid", openid);
    }

    public void addHeadUrlParam(String headurl) {
        addParam("headimgurl", headurl);
    }

    public void addDeviceTokenParam(String userid, String regId) {
        addUserNameParam(userid);
        addUserIdParam();
        addParam("xmToken", regId);

    }

    public void addHWToken(String hWToken) {
        addParam("hWToken", hWToken);
    }

    public void addXMToken(String regId) {
        addParam("xmToken", regId);
    }

    //    public void addBindWechatParam(WechatUserDetail wechat) {
//        addParam("sex", wechat.getSex());
//        addParam("nickName", wechat.getNickname());
//        addParam("imageUrl", wechat.getHeadimgurl());
//        addParam("city", wechat.getCity());
//        addParam("province", wechat.getProvince());
//        addParam("country", wechat.getCountry());
//        addParam("openid", wechat.getOpenid());
//
//    }
//
//    public void addLoginUserParam(UserInfo userInfo) {
//        addAreaCodeParam(userInfo.getAreaCode());
//        addUserNameParam(userInfo.getUsername());
//        addParam("password", userInfo.getPassword());
//    }
//
    private void addGParam() {
//        g.setDeviceId(SystemUtils.getDeviceId());
//        g.setToken("-1");
//        g.setDt("1");
//        g.setAv(SystemUtils.getAppVersionCode() + "");
//        g.setAt("0");
//        g.setSv(StringUtils.getString(R.string.msg_label_service_version));
//        g.setInfo(SystemUtils.getSystemInfo());
//        g.setEtp(System.currentTimeMillis() + "");
//        g.setUuid(ECKit.getApp().getConfigManager().getUUID());
//        this.privateKey = MD5Util.MD5(Setting.PREFS_NAME + g.getEtp());
        this.privateKey = MD5Util.MD5(Setting.PREFS_NAME);
        if (SharePrefUtils.getInstance().isLogin()) {
            //g.setToken(SharePrefUtils.getInstance().getToken());
        }
//        g.setDdjm(EncryptUtils.encodeRsa(RSAUtils.getPublicKey(), privateKey));

        //  addParam("G", g);
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }

//    public Object getParams(String key) {
//        return params.get(key);
//    }
//
//    public String getKeywordsParams() {
//        return getParams("keywords") == null ? null : getParams("keywords") + "";
//    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUrl() {
        return baseUrl + (requestName == null ? "" : requestName);
    }

//    public String getFullUrl() {
//        return getUrl() + "?" + Setting.JSON_PARAMS + "=" + getParams();
//    }
//
//    public String getParams() {
//        String fullUrl = "";
//        switch (http_type) {
//            case HTTP_POST:
//                addGParam();
//                fullUrl = Constant.GSON.toJson(params);
//                break;
//            case HTTP_GET:
//                fullUrl = "";
//                break;
//        }
//        return fullUrl;
//    }

    /**
     * 转换成普通Url格式
     *
     * @return
     */
    public void setRequestMethod(RequestMethod method) {
        http_type = method;
        String rs = "?";
        Iterator iter = params.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object value = params.get(key);
            rs += key + "=" + value;
            if (iter.hasNext()) {
                rs += "&";
            }
        }
        this.requestName = rs;
    }

    public void destory() {
        cls = null;
        params = null;
        type = null;
        headers = null;
        baseUrl = null;
        requestName = null;
    }

    public FormFile[] getFiles() {
        return files;
    }

    public void setFiles(FormFile[] files) {
        this.files = files;
    }

    public Map<String, String> getJsonParams() {
        Map<String, String> params = new HashMap<String, String>();
        String jsonParams = getParams();
        //  String sign = MD5Util.MD5(EncryptKey.getSecretKeyFromJni() + jsonParams);
        params.put(Setting.JSON_PARAMS, jsonParams);
        //  params.put(Setting.SIGN_PARAMS, sign);
        return params;
    }

    public String getParams() {
        String fullUrl = "";
        switch (http_type) {
            case HTTP_POST:
                addGParam();
                fullUrl = Constant.GSON.toJson(params);
                break;
            case HTTP_GET:
                fullUrl = "";
                break;
        }
        return fullUrl;
    }


    public boolean isHttpGet() {
        return http_type == HTTP_GET;
    }

    public Map<String, String> getHeaders() {
        return null;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

//    public G getG() {
//        addGParam();
//        return g;
//    }
}

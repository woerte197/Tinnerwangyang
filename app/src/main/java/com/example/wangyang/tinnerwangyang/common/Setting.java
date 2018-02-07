package com.example.wangyang.tinnerwangyang.common;

import android.net.Uri;
import android.os.Build;


public class Setting {
    // 启动Activity时传入的key值
    public static final String KEY_URL = "url";
    public static final String KEY_SID = "sid";
    public static final String KEY_DETAIL = "detail";
    public static final String KEY_ARTICLE = "artile";
    public static final String KEY_STR_ARG = "title";
    public static final String KEY_ACTION = "activity_action";
    public static final String KEY_SHOW_SHARE = "activity_show_share";
    public static final String KEY_SHOW_TITLE = "activity_show_title";
    public static final String KEY_TITLE = "activity_title";
    public static final String KEY_CONTENT = "activity_content";
    public static final String KEY_SHOWTAB = "showtab";
    public static final String KEY_CONTENTID = "contentId";
    public static final String KEY_PHONENUM = "phonenum";
    public static final String KEY_ORDER = "order";
    public static final String KEY_CHECKLOGN = "checklogin";
    public static final String KEY_FROM_PATH = "fromPath";
    public static final String KEY_OFFERSCHOOL = "offer_school";
    public static final String KEY_OFFERRANK = "offer_rank";
    public static final String KEY_OFFERMAJOR = "offer_major";
    public static final String KEY_NATION = "nation";
    public static final String KEY_SEARCH = "search_item";
    public static final int VALUE_SHOW_ARTILCE = 0;
    public static final int VALUE_SHOW_USER = 2;
    public static final int VALUE_SHOW_ANSWER = 2;

    public static final String XIAOMI_APPKEY = "2882303761517412644";
    public static final String XIAOMI_APPVALUE = "5401741277644";
    public static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";
    public static final String PUBLIC_KEY_PEM = "public_key.pem";
    public static final String RECEVICE_UM_REPLY = ".umpushreply.recevicer";
    public static final String PREFS_NAME = "jiemo";
    public static final String EMMDB_NAME = "/files/easemobDB/";
    public static final String IMAGE_SEP_SM = "-sm";
    public static final String JSON_PARAMS = "jsonParams";
    public static final String SIGN_PARAMS = "sign";
    public static final String URL_ENCODE = "UTF-8";
    public static final String STR_HTTP = "http";
    public static final String EXTRA_RESULT = "select_result";

    public static final String FILE_DB_NAME = PREFS_NAME;
    public static final String FILE_ROOT_FILE = PREFS_NAME;
    public static final String FILE_DOWNLOAD_FOLDER = "download";
    public static final String FILE_IMAGE_FOLDER = "img";
    public static final String FILE_IMAGE_WECHAT_FOLDER = "wechat";

    public static final String FILE_LOG_FILE = FILE_ROOT_FILE + "log.txt";
    public static final int REQUEST_CAMERA = 100;
    /**
     * 单选
     */
    public static final int MODE_SINGLE = 0;
    /**
     * 多选
     */
    public static final int MODE_MULTI = 1;
    /**
     * 是否显示相机，默认显示
     */
    public static final String EXTRA_SHOW_CAMERA = "show_camera";
    /**
     * 最大图片选择次数，int类型，默认9
     */
    public static final String EXTRA_SELECT_COUNT = "max_select_count";
    /**
     * 图片选择模式，默认多选
     */
    public static final String EXTRA_SELECT_MODE = "select_count_mode";
    /**
     * 默认选择集
     */
    public static final String EXTRA_DEFAULT_SELECTED_LIST = "default_list";


    //数据库字段
    public static final String LOGIN_TYPE = "logintype";
    public static final String DBFIELD_LOGINUSERID = "loginUserId";
    public static final String DBFIELD_USERID = "userId";
    public static final String DBFIELD_USERNAME = "username";
    public static final String DBFIELD_NICKNAME = "nickName";
    public static final String DBFIELD_IMAGEURL = "imageUrl";
    public static final String DBFIELD_SHOWSOUND = "showsound";
    public static final String DBFIELD_VIBRATE = "showVibrate";
    public static final String DBFIELD_SHOWNOTICATION = "showNotifaction";
    public static final String DBFIELD_TOKEN = "token";
    public static final String DBFIELD_USERPN = "pn";
    public static final String DBFIELD_AUTOID = "autoid";
    public static final String DBFIELD_XMUNREAD = "xiaomiunread";
    public static final String DBFIELD_NEWS = "news_unread";
    public static final String DBFIELD_ACTIVE = "news_active_unread";
    public static final String DBFIELD_XMTOKEN = "xmtoken";
    public static final String DBFIELD_HWTOKEN = "hwtoken";
    public static final String DBFIELD_UMTOKEN = "umtoken";
    public static final String DBFIELD_OTHER_NICK = "other_nick";
    public static final String DBFIELD_OTHER_IMG = "other_img";
    public static final String MYBEAN = "mybean";
    public static final String DBFIELD_WEIGHT = "weight";
    public static final String DBFIELD_DOWNLOADPROCESS = "downloadprocess";
    public static final String DBFIELD_SHOW_CLOULD_DIALOG = "show_clould_dialog";
    public static final String DBFIELD_CHOCIE_BLOCKID = "choice_blockid";
    public static final String DBFIELD_DEFAULT_SELECT_NATION = "default_select_nation";
    public static final String DBFIELD_CONFIG_NAME = "configName";
    public static final String DBFIELD_LIVE_ROOM_GROUPID_SET = "liveroomgroupidset";
    public static final String FORWARD_MSG_ID = "forward_msg_id";

    public static final String DBFIELD_COOKIE_DT = "dt=1";

    public static final String STR_PRE_ANDROID_RESOURCE = "android.resource://";
    public static final String REF_SET_MESSAGE_COUNT = "setMessageCount";
    public static final String REF_EXTRA_NOTIFICATION = "extraNotification";
    public static final String HX_STR_EE = "ee_";
    public static final String HX_STR_DELETE_EXPRESSION = "delete_expression";
    public static final String HX_STR_GROUP_ID = "groupId";
    public static final String HX_STR_CHAT_TYPE = "chatType";
    public static final String COPY_IMAGE = "EASEMOBIMG";
    public static final int RESULT_CODE_COPY = 1;
    public static final int RESULT_CODE_DELETE = 2;
    public static final int RESULT_CODE_FORWARD = 3;
    public static final int RESULT_CODE_OPEN = 4;
    public static final int RESULT_CODE_DWONLOAD = 5;
    public static final int RESULT_CODE_TO_CLOUD = 6;
    public static final int RESULT_CODE_EXIT_GROUP = 7;


    public static final String ULR_PRE_PACKAGE = "package:";
    public static final String URL_PRE_FILE = "file://";
    public static final String INSTALL_STR_APPLICATION_VND_ANDROID_PACKAGE_ARCHIVE = "application/vnd.android.package-archive";
    public static final String ACTIVITY_ACTION_ANDROID_INTENT_ACTION_VIEW = "android.intent.action.VIEW";
    public static final String FILE_EXT_JPG = ".jpg";
    public static final String FILE_EXT_APK = ".apk";

    public static final String JS_DELEGE_MOBILE = "mobile";
    public static final String JS_METHOD_GET_TITLE_BAR_INFO = "getTitleBarInfo";
    public static final String JS_METHOD_GET_CHECK_LOGOUT = "checkLoginStatus";

    //消息界面特殊的几个变量
    public static final int KEY_EXT_SYSMSG = -5;

    //发布贴子界面
    public static final int PUBLIC_ARTICLE = 0;
    public static final int PUBLIC_QUESTION = 1;
    public static final int PUBLIC_REPLY = 2;
    // config参数说明
    public static final String CONFIG_PARA_VERSION = "version";                                // 版本
    public static final String CONFIG_PARA_VIDEO = "video";                                       // 视频
    public static final String CONFIG_PARA_NATION_GROUP = "nationGroup";                       // 意向国家圈子
    public static final String CONFIG_PARA_ARTICLE_GROUP = "publicArticleGroup";               // 发贴界面圈子
    public static final String CONFIG_PARA_INFO_NATION_GROUP = "infoNationGroup";               // 发贴界面圈子
    public static final String CONFIG_PARA_SYSTEM_MESSAGE_NEW = "newSystemMessage";            // 最新的系统消息
    public static final String CONFIG_PARA_SYSTEM_MESSAGE_BLOCKID = "systemMessageBlockId";    // 系统消息版块id
    public static final String CONFIG_PARA_PUBLIC_DEFAULT_BLOCKID = "defaultGroupId";          // 默认发贴圈子id
    public static final String CONFIG_PARA_QUESTION_DEFAULT_BLOCKID = "defaultQuestionGroup";  // 默认提问圈子id
    public static final String CONFIG_PARA_QUICK_MENUS = "quickMenus";                       // 快捷菜单
    public static final String CONFIG_PARA_TEACHER_MANAGER_ADDR = "teacherManagerAddr";       // 都是管理地址
    public static final String CONFIG_PARA_SELECT_NATION_ADDR = "selectNationAddr";           // 选择国家地址
    public static final String CONFIG_PARA_TAB_WEB_ADDR = "tabWebAddr";           // 选择国家地址
    public static final String CONFIG_PARA_ASK_TEACHER_ADDR = "askTeacherAddr";               // 问都是地址
    public static final String CONFIG_PARA_USER_PROTOCOL_ADDR = "userProtocolAddr";           // 用户协议地址
    public static final String CONFIG_PARA_ABOUT_PROTOCOL_ADDR = "userAboutAddr";               // 关于界面地址
    public static final String CONFIG_PARA_DISCLAIMER_PROTOCOL_ADDR = "userDisclaimerAddr";    // 免责声明地址
    public static final String CONFIG_PARA_WEIBO_ADDR = "weiboAddr";                           // 关注微博地址
    public static final String CONFIG_PARA_GPA_ADDR = "gpaAddr";                               // GPA地址
    public static final String CONFIG_PARA_PERSENT_ADDR = "persentAddr";                       // 邀请有礼地址
    public static final String CONFIG_PARA_CRM_MENU_QQ = "crmmenuqq";                   // CRM_MENU_QQ
    public static final String CONFIG_PARA_SHARE_IMAGE_ADDR = "shareImageAddr";               // 分享图片地址
    public static final String CONFIG_PARA_CHOICE_NATION = "choiceNation";                   // 国家信息
    public static final String CONFIG_PARA_REGISTER_CHOICE_NATION = "registerNation";           // 注册国家信息
    public static final String CONFIG_PARA_PHONE_NATION = "phoneNation";               // 国家信息
    public static final String CONFIG_PARA_SOS = "SOS";                                       // 老师信息
    public static final String CONFIG_PARA_HOT_TAGES = "hotSearchSchool";                           // 热门标签
    public static final String CONFIG_PARA_HOT_SEARCH = "hotSearch";                            //热门搜索
    public static final String CONFIG_PARA_UUID = "uuid";                              // uuid

    //软键盘默认高度
    public static final String DEF_KEYBOARD_CHAT_HEIGHT = "default_keyboard_chat_height";

    public static boolean S_ISDEBUG = true;        //开启调度模式，显示缓存，使用测试服务器数据,此处得手动修改AndroidManifest 中的 EASEMOB_APPKEY = jlxtest。
    public static boolean S_SHOW_CACHE = false;     //是否显示cache

//    static {
//        S_ISDEBUG = StringUtils.getAPPDEBUGMetaValue().equals("true");
//        S_SHOW_CACHE = StringUtils.getAPP_SHOW_LOG_MetaValue().equals("true");
////		S_ISDEBUG =false;
//    }

    public static final String PRE_VIDEO_URL = "http://video.jiemo.net";
    public static final int FLAG_NOTIFICATION_REPLY = 2; //回复的通知显示模式
    public static final int SIZE_PAGE = 20;              //分页数量 jamessu1
    public static final int SIZE_MAX_PAGE = 100;         //最大分页数
    public static final int SIZE_RECOMMED_PAGE = 3;      //推荐显示数量
    public static final int SIZE_MAX_UPLOAD = 9;         //最多上传图片数量
    public static final int SIZE_MAX_GRIDVIEW = 9;       //最多资讯图片数量
    public static final int SIZE_MAX_EMO = 35;           //表情数量
    public static final int SIZE_MAX_GROUP_SIZE = 13;    //群组列表显示数量
    public static final int SIZE_MAX_PRESS_TIME = 2000;  //返回按钮连按间隔
    public static final int SIZE_SEND_MESSAGE_INTERVAL = 2000; //显示消息的时间间隔
    public static final long MAX_SIZE = 1024 * 1024 * 4; //上传的图片的最大值
    public static final String IMAGE_PATTER = "▓";       //图片替代符
    public static final String UPLOAD_PIC = "picture";   //上传图片路径
    public static final String UPLOAD_AVATAR = "avatar"; //上传头像路径
    public static final String PACKAGE_UMENG = "com.umeng.share"; //友盟包名
    public static final String PACKAGE_COM_TENCENT_MOBILEQQ = "com.tencent.mobileqq";
    public static final String PACKAGE_COM_SINA_WEIBO = "com.sina.weibo";
    public static final String PACKAGE_COM_AL_ZHIFUBAO = "com.eg.android.AlipayGphone";
    public static final String SHARE_WECHAT_WECHAT_SDK_DEMO_TEST = "wechat_sdk_demo_test";
    public static final String SHSARE_WECHAT_SNSAPI_USERINFO = "snsapi_userinfo";
//    public static final int[] VIEWPAGER_STYLE = new int[]{R.drawable.danpin_dot2, R.drawable.danpin_dot1};                   //viewpager小点显示样式
//    public static final HXMessageItem SYSSTEM_MESSAGE = new HXMessageItem(Setting.KEY_EXT_SYSMSG, R.drawable.icon_hxmessage_sys, StringUtils.getString(R.string.msg_label_sys_msg), SysMessageListActivity.class); //系统消息行
//    public static final HXMessageItem COMMENT_MESSAGE = new HXMessageItem(Setting.KEY_EXT_SYSMSG, R.drawable.ic_msg_comment, StringUtils.getString(R.string.msg_label_comment_msg), SysMessageListActivity.class); //评论消息行
//    public static final int SHOW_TYPE_NATION = 0;
//    public static final int SHOW_TYPE_ARTICLE = 1;
//    public static final long[] vibrate = {0, 100, 200, 300};
//    public static final Uri soundUri = Uri.parse(Setting.STR_PRE_ANDROID_RESOURCE + ECKit.getApp().getPackageName() + "/" + R.raw.beep);

    public static final int http_load_un = -1;
    public static final int http_load_success = 0;
    public static final int http_load_fail = 1;
    public static final int http_load_prepare = 2;
    public static final int http_load_loading = 3;
    public static final int http_load_cache_success = 4;
    public static final int http_load_stop = 5;

    //小米判断
    public static final String XIAOMI = "Xiaomi";
    public static final boolean isHuawei = Build.BRAND.toLowerCase().equals("huawei") || Build.BRAND.toLowerCase().equals("honor");
    public static boolean isPulling = false;
    public static final String TABUSERFRAGMENT = "TabUserFragment";

}

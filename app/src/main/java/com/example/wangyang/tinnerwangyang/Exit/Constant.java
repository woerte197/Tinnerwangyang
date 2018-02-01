package com.example.wangyang.tinnerwangyang.Exit;

import com.example.wangyang.tinnerwangyang.Bean.ItemsBean;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.News;
import com.example.wangyang.tinnerwangyang.Bean.PhonePageList;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by wangyang on 29/12/17.s
 */

public class Constant {
    public static  final Gson GSON=new Gson();
    public static final Type TYPE_RECOMMEND=new TypeToken<RecommendBean>(){}.getType();
    public static final Type TYPE_RESULT_NEWBEAN=new TypeToken<Result<Knowledges>>(){}.getType();
    public static final Type TYPE_RESULT_ITEMBEANS=new TypeToken<Result<ItemsBean>>(){}.getType();
    public static final Type TYPE_RESULT_POSTSBEANS=new TypeToken<Result<PostsBean>>(){}.getType();
    public static final Type TYPE_RESULT_PHONELIST_NEWS = new TypeToken<Result<PhonePageList<News>>>(){}.getType(); //分页数据

}

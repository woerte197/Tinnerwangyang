package com.example.wangyang.tinnerwangyang;

import android.view.View;

import com.example.wangyang.tinnerwangyang.Bean.Background;
import com.example.wangyang.tinnerwangyang.Bean.FoodBean;
import com.example.wangyang.tinnerwangyang.Bean.FoodTitle;
import com.example.wangyang.tinnerwangyang.Bean.GrassesBean;
import com.example.wangyang.tinnerwangyang.Bean.HotEventsBean;
import com.example.wangyang.tinnerwangyang.Bean.ItemsBean;
import com.example.wangyang.tinnerwangyang.Bean.Knowledges;
import com.example.wangyang.tinnerwangyang.Bean.MyBean;
import com.example.wangyang.tinnerwangyang.Bean.MyItem;
import com.example.wangyang.tinnerwangyang.Bean.News;
import com.example.wangyang.tinnerwangyang.Bean.NewsTitle;
import com.example.wangyang.tinnerwangyang.Bean.Photos;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.Bean.ShowUsersBean;
import com.example.wangyang.tinnerwangyang.Bean.SlidersBean;
import com.example.wangyang.tinnerwangyang.Bean.SportBean;
import com.example.wangyang.tinnerwangyang.Bean.Success;
import com.example.wangyang.tinnerwangyang.Bean.TagsBean;
import com.example.wangyang.tinnerwangyang.Bean.TodayItem;
import com.example.wangyang.tinnerwangyang.ViewHolder.BaseRecyclerHolder;


/**
 * Created by nanchaodong on 2017/3/7.
 */

public interface TypeFactory {
    BaseRecyclerHolder createViewHolder(int type, View itemView);
    int type(Knowledges knowledges);
    int type(FooterItem footerItem);
    int type(News news);
    int type(SlidersBean slidersBean);
    int type(GrassesBean grassesBean);
    int type(HotEventsBean hotEventsBean);
    int type(ShowUsersBean showUsersBean);
    int type(RecommendBean recommendBean);
    int type(NewsTitle newsTitle);
    int type(Success success);
    int type(ItemsBean itemsBean);
    int type(TagsBean tagsBean);
    int type(PostsBean postsBean);
    int type(Photos photos);
    int type(MyBean myBean);
    int type(MyItem myItem);
    int type(TodayItem todayItem);
    int type(FoodBean foodBean);
    int type(FoodTitle foodTitle);
    int type(Background background);
    int type(SportBean sportBean);

}

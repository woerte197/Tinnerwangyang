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
import com.example.wangyang.tinnerwangyang.ViewHolder.NewsTitleHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.RecommendBannerHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.RecommendHealthChannelHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.RecommendPopularActivityHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewBackGroundItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewFoodTitleItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewImageItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewItemBeansHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewMorningFoodItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewMyBodyItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewMyHeaderItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewNewHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewNewsHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewPostsBeansItemHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewSportItemSportHolder;
import com.example.wangyang.tinnerwangyang.ViewHolder.ViewTodayItemHolder;


/**
 * Created by nanchaodong on 2017/3/7.
 */

public class TypeFactoryList implements TypeFactory {

    public static final int LAYOUT_NEWS_ITEM = R.layout.layout_news;
    public static final int LAYOUT_NEW_ITEM = R.layout.layout_new;
    private static final int FOOTER_VIEW_ITEM = R.layout.recycler_footer_item;
    private static final int RECOMMEND_BINNER = R.layout.layout_recommend_binner;
    private static final int RECOMMEND_HEALTH_CHANNEL = R.layout.layout_health_channel;
    private static final int RECOMMEND_POPULAR_ACTIVITY = R.layout.layout_popular_activity;
    private static final int NEWS_TITLE_ITEM = R.layout.news_title_item;
    private static final int LAYOUT_ITEMBEANS = R.layout.layout_itembeans;
    private static final int LAYOUT_POSTSBEANS = R.layout.layout_postsbean;
    private static final int LAYOUT_PHOTOS = R.layout.layout_image;
    private static final int LAYOUT_MY = R.layout.layout_my;
    private static final int LAYOUT_MY_ITEM = R.layout.layout_my_item;
    private static final int LAYOUT_TODAY_ITEM = R.layout.layout_today_item;
    private static final int LAYOUT_MORNING_FOOD = R.layout.layout_morningfood;
    private static final int LAYOUT_FOOD_TITLE = R.layout.layout_foodtitle;
    private static final int LAYOUT_BACKGROUND = R.layout.layout_background;
    private static final int LAYOUT_SPORT = R.layout.layout_sports;


    @Override
    public int type(Knowledges knowledges) {
        return LAYOUT_NEWS_ITEM;
    }

    @Override
    public int type(FooterItem footerItem) {
        return FOOTER_VIEW_ITEM;
    }

    @Override
    public int type(News news) {
        return LAYOUT_NEW_ITEM;
    }

    @Override
    public int type(SlidersBean slidersBean) {
        return RECOMMEND_BINNER;
    }

    @Override
    public int type(GrassesBean grassesBean) {
        return RECOMMEND_HEALTH_CHANNEL;
    }

    @Override
    public int type(HotEventsBean hotEventsBean) {
        return RECOMMEND_POPULAR_ACTIVITY;
    }

    @Override
    public int type(ShowUsersBean showUsersBean) {
        return 0;
    }

    @Override
    public int type(RecommendBean recommendBean) {
        if (recommendBean.getSliders() != null) {
            return RECOMMEND_BINNER;
        }
        ;
        return RECOMMEND_BINNER;
    }

    @Override
    public int type(NewsTitle newsTitle) {
        return NEWS_TITLE_ITEM;
    }

    @Override
    public int type(Success success) {
        return 0;
    }

    @Override
    public int type(ItemsBean itemsBean) {
        return LAYOUT_ITEMBEANS;
    }

    @Override
    public int type(TagsBean tagsBean) {
        return 0;
    }

    @Override
    public int type(PostsBean postsBean) {
        return LAYOUT_POSTSBEANS;
    }

    @Override
    public int type(Photos photos) {
        return LAYOUT_PHOTOS;
    }

    @Override
    public int type(MyBean myBean) {
            return LAYOUT_MY;

    }

    @Override
    public int type(MyItem myItem) {

        return LAYOUT_MY_ITEM;
    }

    @Override
    public int type(TodayItem todayItem) {
        return LAYOUT_TODAY_ITEM;
    }

    @Override
    public int type(FoodBean foodBean) {
        return LAYOUT_MORNING_FOOD;
    }

    @Override
    public int type(FoodTitle foodTitle) {
        return LAYOUT_FOOD_TITLE;
    }

    @Override
    public int type(Background background) {
        return LAYOUT_BACKGROUND;
    }

    @Override
    public int type(SportBean sportBean) {
        return LAYOUT_SPORT;
    }

    @Override
    public BaseRecyclerHolder createViewHolder(int type, View itemView) {
        switch (type) {
            case LAYOUT_NEWS_ITEM:
                return new ViewNewsHolder(itemView);
            case LAYOUT_NEW_ITEM:
                return new ViewNewHolder(itemView);
            case FOOTER_VIEW_ITEM:
                return new FooterHold(itemView);
            case RECOMMEND_BINNER:
                return new RecommendBannerHolder(itemView);
            case RECOMMEND_HEALTH_CHANNEL:
                return new RecommendHealthChannelHolder(itemView);
            case RECOMMEND_POPULAR_ACTIVITY:
                return new RecommendPopularActivityHolder(itemView);
            case NEWS_TITLE_ITEM:
                return new NewsTitleHolder(itemView);
            case LAYOUT_ITEMBEANS:
                return new ViewItemBeansHolder(itemView);
            case LAYOUT_POSTSBEANS:
                return new ViewPostsBeansItemHolder(itemView);
            case LAYOUT_PHOTOS:
                return new ViewImageItemHolder(itemView);
            case LAYOUT_MY:
                return new ViewMyHeaderItemHolder(itemView);
            case LAYOUT_MY_ITEM:
                return new ViewMyBodyItemHolder(itemView);
            case LAYOUT_TODAY_ITEM:
                return new ViewTodayItemHolder(itemView);
            case LAYOUT_MORNING_FOOD:
                return new ViewMorningFoodItemHolder(itemView);
            case LAYOUT_FOOD_TITLE:
                return new ViewFoodTitleItemHolder(itemView);
            case LAYOUT_BACKGROUND:
                return new ViewBackGroundItemHolder(itemView);
            case LAYOUT_SPORT:
                return new ViewSportItemSportHolder(itemView);
            default:

                return null;
        }

    }
}

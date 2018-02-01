package com.example.wangyang.tinnerwangyang.Bean;

import com.example.wangyang.tinnerwangyang.TypeFactory;
import com.example.wangyang.tinnerwangyang.Wachter;

import java.util.List;

/**
 * Created by wangyang on 9/1/18.
 */

public class ItemsBean implements Wachter{
        /**
         * id : 194
         * title : 瘦30斤，甩掉疾病，彻底告别过去的自己……
         * pic : http://one.boohee.cn//status/stories/story/2018/1/3/91118aaa8120ed530989ac59e4f485ab?imageView2/1/w/240/h/180
         * url : https://status.boohee.com/story/20180103
         * tags : ["上班族","60~70 kg","复胖","瘦全身","减肥食谱"]
         */

        private int id;
        private String title;
        private String pic;
        private String url;
        private List<String> tags;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
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


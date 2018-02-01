package com.example.wangyang.tinnerwangyang.Bean;

/**
 * Created by wangyang on 2/1/18.
 */

public class PageRequest {
    private int startIndex;
    private int pageSize ;
    private long sortId  ;
    private int loadType;
    private int page;
    private int start;

    public PageRequest(int start, int pageSize){
     super();
     this.startIndex=start;
     this.pageSize=pageSize;

 }

    public int getStart() {
        return startIndex;
    }

    public void setStart(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getSortId() {
        return sortId;
    }

    public void setSortId(long sortId) {
        this.sortId = sortId;
    }

    public int getLoadType() {
        return loadType;
    }

    public void setLoadType(int loadType) {
        this.loadType = loadType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                ", sortId=" + sortId +
                ", loadType=" + loadType +
                ", page=" + page +
                '}';
    }


}

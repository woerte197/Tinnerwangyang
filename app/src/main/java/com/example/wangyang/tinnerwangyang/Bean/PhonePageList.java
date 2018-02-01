package com.example.wangyang.tinnerwangyang.Bean;

import java.util.List;

/**
 * Created by wangyang on 2/1/18.
 */

public class PhonePageList<T> {
    private Integer total;
    private List<T> records;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public List<T> getRecords(){
        return records;

    }
}

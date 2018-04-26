package com.web.entity.respo;

import com.web.entity.dbo.FeedBackBean;

import java.util.List;

public class RespFeedBackListBean extends ResponseBean {
    private List<FeedBackBean> data;

    public List<FeedBackBean> getData() {
        return data;
    }

    public void setData(List<FeedBackBean> data) {
        this.data = data;
    }
}

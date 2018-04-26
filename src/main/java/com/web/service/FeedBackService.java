package com.web.service;

import com.web.entity.dbo.FeedBackBean;

import java.util.List;

public interface FeedBackService {

    void feedBack(FeedBackBean feedBackBean);

    List<FeedBackBean> getAllFeedBack();
}

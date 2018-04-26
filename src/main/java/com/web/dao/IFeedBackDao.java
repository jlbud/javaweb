package com.web.dao;

import com.web.entity.dbo.FeedBackBean;

import java.util.List;

public interface IFeedBackDao {

    int insert(FeedBackBean record);

    List<FeedBackBean> getAllFeedBack();
}
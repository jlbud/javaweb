package com.web.service.impl;

import com.web.dao.IFeedBackDao;
import com.web.entity.FeedBackBean;
import com.web.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feedBackService")
public class IFeedBackService implements FeedBackService {

  @Autowired
  private IFeedBackDao feedBackDao;

  @Override
  public void feedBack(FeedBackBean feedBackBean) {
    feedBackDao.insert(feedBackBean);
  }

}

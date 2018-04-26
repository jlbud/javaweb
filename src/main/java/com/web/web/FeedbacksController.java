package com.web.web;

import com.web.common.JsonUtils;
import com.web.entity.dbo.FeedBackBean;
import com.web.entity.respo.RespFeedBackBean;
import com.web.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * kevin
 */

@Controller
@RequestMapping("/xiaoshi")
public class FeedbacksController {

    @Resource
    private FeedBackService feedBackService;

    /**
     * 意见反馈 V1.0
     *
     * @param feedBackBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = "application/json")
    public String feedback(@RequestBody FeedBackBean feedBackBean) {
        if (feedBackBean != null) {
            feedBackService.feedBack(feedBackBean);
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("pass");
            backBean.setSuccess("0");
            return JsonUtils.responJson(backBean);
        } else {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("fail");
            backBean.setSuccess("-1");
            backBean.setData("content is null");
            return JsonUtils.responJson(backBean);
        }
    }

}

package com.web.web;

import com.web.common.ResponseUtils;
import com.web.entity.dbo.FeedBackBean;
import com.web.entity.respo.RespFeedBackBean;
import com.web.entity.respo.RespFeedBackListBean;
import com.web.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * create by kevin
 * </p>
 * about feedback
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
    public void feedback(@RequestBody FeedBackBean feedBackBean, HttpServletResponse response) {
        if (feedBackBean != null) {
            feedBackService.feedBack(feedBackBean);
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("pass");
            backBean.setSuccess("0");
            ResponseUtils.renderJson(response, backBean);
        } else {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("fail");
            backBean.setSuccess("-1");
            backBean.setData("content is null");
            ResponseUtils.renderJson(response, backBean);
        }
    }

    /**
     * 获取所有的反馈
     *
     * @return
     */
    @RequestMapping(value = "feedback/all", method = RequestMethod.GET, consumes = "application/json")
    public void getAllFeedBack(HttpServletRequest request, HttpServletResponse response) {
        List<FeedBackBean> feedBackList = feedBackService.getAllFeedBack();
        RespFeedBackListBean backListBean = new RespFeedBackListBean();
        if (feedBackList != null) {
            backListBean.setData(feedBackList);
            backListBean.setSuccess("0");
        } else {
            backListBean.setSuccess("-1");
        }
        ResponseUtils.renderJson(response, backListBean);
    }

    /**
     * 获取某个用户的反馈
     */
    @RequestMapping(value = "feedback/all/{userId}", method = RequestMethod.GET, produces = "application/json")
    public String getFeedBackByUserId() {
        return "";
    }

}

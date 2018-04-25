package com.web.web;

import com.web.entity.FeedBackBean;
import com.web.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * kevin
 */

@Controller
@RequestMapping("/xiaoshi")
public class FeedbacksController {

    @Resource
    private FeedBackService feedBackService;

    @ResponseBody
    @RequestMapping(value="/feedback" ,method = RequestMethod.POST,consumes = "application/json")
    public String login(@RequestBody FeedBackBean feedBackBean) {
//        String email = request.getParameter("email");
//        String content = request.getParameter("content");
//        FeedBackBean backBean = new FeedBackBean();
//        backBean.setContent(content);
//        backBean.setEmail(email);
        feedBackService.feedBack(feedBackBean);
        return "feedBackSuccess";
    }

}

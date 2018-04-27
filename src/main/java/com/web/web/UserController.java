package com.web.web;

import com.web.common.ResponseUtils;
import com.web.entity.dbo.UserBean;
import com.web.entity.respo.RespFeedBackBean;
import com.web.entity.respo.RespUserBean;
import com.web.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * create by kevin
 * <p/>
 * about user
 */

@Controller
@RequestMapping("/xiaoshi/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * register V1.0
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody UserBean userBean, HttpServletResponse response) {
        boolean isSuccess = userService.register(userBean);
        if (isSuccess) {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("pass");
            backBean.setSuccess("0");
            ResponseUtils.renderJson(response, backBean);
        } else {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("fail");
            backBean.setSuccess("-1");
            backBean.setData("register fail");
            ResponseUtils.renderJson(response, backBean);

        }
    }

    /**
     * login V1.0
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public void login(@RequestBody UserBean userBean, HttpServletResponse response) {
        if (userBean == null || userBean.getPhone().equals("") || userBean.getPhone() == null) {
            RespUserBean respUserBean = new RespUserBean();
            respUserBean.setSuccess("-1");
            ResponseUtils.renderJson(response, respUserBean);
        } else {
            UserBean bean = userService.login(userBean);
            if (bean == null) {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("-1");
                ResponseUtils.renderJson(response, respUserBean);
            } else {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("0");
                respUserBean.setData(bean);
                ResponseUtils.renderJson(response, respUserBean);
            }
        }
    }

    /**
     * upload user avatar V1.0
     *
     * @param file
     * @param response
     */
    @RequestMapping(value = "/upload/avatar", method = RequestMethod.POST, consumes = "multipart/form-data;charset=utf-8")
    public void doUploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        if (!file.isEmpty()) {
            try {
                //这里将上传得到的文件保存至 windows d:\\temp\\file 目录,linux /Users/liuwei01/Downloads
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/Users/liuwei01/Pictures/",
                        System.currentTimeMillis() + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        RespUserBean respUserBean = new RespUserBean();
        respUserBean.setSuccess("0");
        ResponseUtils.renderJson(response, respUserBean);
    }

    /**
     * upload multi file
     *
     * @param multiRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doMultiUpload", method = RequestMethod.POST, consumes = "multipart/form-data;charset=utf-8")
    public void doUploadFileMulti(MultipartHttpServletRequest multiRequest, HttpServletResponse response) throws IOException {
        Iterator<String> filesNames = multiRequest.getFileNames();//获得所有的文件名
        while (filesNames.hasNext()) {
            String fileName = filesNames.next();
            MultipartFile file = multiRequest.getFile(fileName);
            if (!file.isEmpty()) {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/Users/liuwei01/Pictures/",
                        System.currentTimeMillis() + file.getOriginalFilename()));
            }
        }
        RespUserBean respUserBean = new RespUserBean();
        respUserBean.setSuccess("0");
        ResponseUtils.renderJson(response, respUserBean);
    }

    @RequestMapping("/search")
    public String search() {
        return "login";
    }
}

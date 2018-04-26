package com.web.entity.respo;

import com.web.entity.dbo.UserBean;

public class RespUserBean extends ResponseBean {
    private UserBean data;

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }
}

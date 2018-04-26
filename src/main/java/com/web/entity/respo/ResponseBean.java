package com.web.entity.respo;

public class ResponseBean {
    protected String success;
    protected String message;

    public ResponseBean(){
    }

    public ResponseBean(String success,String message){
        this.success = success;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.chen.ssm.entity;

public class User {
//    CREATE TABLE `user` (
//            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
//            `email` varchar(255) NOT NULL COMMENT '用户邮箱',
//            `password` varchar(255) NOT NULL COMMENT '用户密码',
//            `username` varchar(255) NOT NULL COMMENT '用户昵称',
//            `phone` varchar(255) NOT NULL COMMENT '用户昵称',
//            `sex` varchar(255) NOT NULL COMMENT '用户昵称',
//            `sfz` varchar(255) NOT NULL COMMENT '用户昵称',
//            `truename` varchar(255) NOT NULL COMMENT '用户昵称',
//    PRIMARY KEY (`id`),
//    UNIQUE KEY `email` (`email`) USING BTREE
//) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
//    INSERT INTO `user` VALUES ('1', '18717825632@163.com', '123456', 'kevin', '187178256', '0', 'shen me gui', 'kevin liu');
//    SET FOREIGN_KEY_CHECKS=1;

    private Integer id;
    private String email;
    private String password;
    private String phone;
    private String sex;
    private String sfz;
    private String truename;
    private String username;
    public void User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz == null ? null : sfz.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
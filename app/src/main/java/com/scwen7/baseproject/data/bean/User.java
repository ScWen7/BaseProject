package com.scwen7.baseproject.data.bean;

/**
 * Created by 解晓辉 on 2017/2/16.
 * 作用：
 */

public class User {
    //手机号
    private String mobile;
    //密码
    private String pwd;
    //令牌  token
    private String token;

    public User() {
    }

    public User(String mobile, String pwd, String token) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.token = token;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

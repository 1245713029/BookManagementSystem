package com.zcf.bean;

/**
 * 用户表
 */
public class UserBean {

    /**
     * id
     */
    private  String id;
    /**
     *  用户名
     *  **/
    private  String  username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 密码
     * **/
    private  String  passwrod;
    /**
     * 姓名
     * **/
    private String name;
    /**
     * 工号
     * **/
    private String gh;
    /**
     * 手机号
     * **/
    private String mobile;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

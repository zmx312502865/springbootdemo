package com.zmx.entity;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

public class AuthUser {


    public  AuthUser(Integer authUserId,Integer userId,String openId,Integer authType, Timestamp createTime)
    {
        this.authUserId=authUserId;
        this.userId=userId;
        this.openId=openId;
        this.authType=authType;
        this.createTime=createTime;

    }

    public  AuthUser(String openId ,int authType) {
        this.openId = openId;
        this.authType = authType;
    }

    public Integer getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Integer authUserId) {
        this.authUserId = authUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    private   Integer authUserId;
   private   Integer userId;
   private   String openId;
   private   Integer authType;
   private Timestamp createTime;
}

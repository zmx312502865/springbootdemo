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
    public  Integer authUserId;
    public  Integer userId;
    public  String openId;
    public  Integer authType;
    public Timestamp createTime;
}

package com.zmx.util;

import com.zmx.entity.AuthUser;
import com.zmx.entity.SysUser;
import com.zmx.service.IAuthUserService;
import com.zmx.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Component("AccountUtil")
public   class  AccountUtil {
    @Autowired(required=true)
    private  IAuthUserService authUserService;
    @Autowired(required=true)
    private  ISysUserService sysUserService;

    public    SysUser  AuthUserLoginOrRegist(String openId,int authType) {
        AuthUser authUser = authUserService.getByOpenId(openId, authType);
       if (authUser != null && authUser.userId > 0) {
            return sysUserService.getById(authUser.userId);
        }
        AutoCreateAuthUser(openId, authType);
        return null;
    }

    public   SysUser  AutoCreateAuthUser(String openId,int authType) {
        AuthUser authUser =new AuthUser(openId,authType);
        authUser.createTime=new Timestamp(new Date().getTime());
        authUserService.Insert(authUser);
        SysUser user=new SysUser();
        user.createTime=new Date();
        int userId  =sysUserService.Insert(user);
        return  null;
    }
}

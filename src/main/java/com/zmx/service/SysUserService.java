package com.zmx.service;

import com.zmx.dao.AuthUserMapper;
import com.zmx.entity.AuthUser;
import com.zmx.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Service("SysUserService")
public class SysUserService implements  ISysUserService {

    @Autowired
    private com.zmx.dao.SysUserMapper sysUserMapper;
    @Autowired(required=true)
    private AuthUserMapper authUserMapper;

    @Override
    public SysUser getById(int id) {
        return sysUserMapper.getById(id);
    }

    @Override
    public ArrayList<SysUser> getAll() {
        return sysUserMapper.getAll();
    }

    @Override
    public int Insert(SysUser sysUser) {
        return sysUserMapper.Insert(sysUser);
    }



    @Override
    public    SysUser  AuthUserLoginOrRegist(String openId,int authType) {
        AuthUser authUser = authUserMapper.getByOpenId(openId, authType);
        if (authUser != null && authUser.userId > 0) {
            return sysUserMapper.getById(authUser.userId);
        }
        return   AutoCreateAuthUser(openId, authType);

    }
    public   SysUser  AutoCreateAuthUser(String openId,int authType) {

        SysUser user = new SysUser();
        user.createTime = new Date();
        user.userName = "test";
        int userId = sysUserMapper.Insert(user);

        AuthUser authUser = new AuthUser(openId, authType);
        authUser.createTime = new Timestamp(new Date().getTime());
        authUser.userId = user.userId;
        authUserMapper.Insert(authUser);
        return user;
    }

}

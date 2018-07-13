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
    public SysUser authUserLoginOrRegist(String openId, int authType, String nickName, String avatarUrl) {
        AuthUser authUser = authUserMapper.getByOpenId(openId, authType);
        if (authUser != null && authUser.getUserId() > 0) {
            return sysUserMapper.getById(authUser.getUserId());
        }
        return   autoCreateAuthUser(openId, authType, nickName,  avatarUrl);

    }
    public   SysUser  autoCreateAuthUser(String openId,int authType,String nickName, String avatarUrl) {

        SysUser user = new SysUser();
        user.setCreateTime(new Date());
        user.setUserName("test");
        user.setNickName(nickName);
        user.setAvatarUrl(avatarUrl);
        int userId = sysUserMapper.Insert(user);

        AuthUser authUser = new AuthUser(openId, authType);
        authUser.setCreateTime(new Timestamp(new Date().getTime()));
        authUser.setUserId(user.getUserId());
        authUserMapper.Insert(authUser);
        return user;
    }

}

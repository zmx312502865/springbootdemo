package com.zmx.service;

import com.zmx.dao.AuthUserMapper;
import com.zmx.entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AuthUserService")
public class AuthUserService implements IAuthUserService {
    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUser getByOpenId(String id, int authType) {
        return authUserMapper.getByOpenId(id,authType);
    }

    @Override
    public ArrayList<AuthUser> getAll() {
        return authUserMapper.getAll();
    }

    @Override
    public int Insert(AuthUser authUser) {
        return authUserMapper.Insert(authUser);
    }
}

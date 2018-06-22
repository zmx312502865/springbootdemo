package com.zmx.service;

import com.zmx.entity.AuthUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface IAuthUserService {
    AuthUser getByOpenId(String id, int authType);

    ArrayList<AuthUser> getAll();
    int Insert(AuthUser authUser);
}

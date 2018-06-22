package com.zmx.service;

import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ISysUserService {

    SysUser getById(int id);
    ArrayList<SysUser> getAll();
    int Insert(SysUser sysUser);

}

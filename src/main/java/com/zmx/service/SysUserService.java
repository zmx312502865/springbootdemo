package com.zmx.service;

import com.zmx.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("SysUserService")
public class SysUserService implements  ISysUserService {

    @Autowired
    private com.zmx.dao.SysUserMapper sysUserMapper;


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
}

package com.zmx.dao;

import com.zmx.entity.AuthUser;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface SysUserMapper {

    @Select("SELECT * FROM SysUser WHERE UserId = #{id}")
    SysUser getById(int id);

    @Select("SELECT * FROM SysUser ")
    ArrayList<SysUser> getAll();
    @Insert("Insert into SysUser(UserName,CreateTime) values(#{UserName},#{CreateTime})")
    @Options(useGeneratedKeys=true,  keyProperty = "UserId", keyColumn = "UserId")
    int Insert(SysUser sysUser);
}

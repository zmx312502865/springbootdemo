package com.zmx.dao;

import com.zmx.entity.AuthUser;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface SysUserMapper {

    @Select("SELECT * FROM sysuser WHERE userId = #{id}")
    SysUser getById(int id);

    @Select("SELECT * FROM sysuser ")
    ArrayList<SysUser> getAll();
    @Insert("Insert into sysuser(userName,createTime) values(#{userName},#{createTime})")
    @Options(useGeneratedKeys=true,  keyProperty = "userId", keyColumn = "userId")
    int Insert(SysUser sysUser);
}

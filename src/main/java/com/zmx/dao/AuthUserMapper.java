package com.zmx.dao;

import com.zmx.entity.AuthUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface AuthUserMapper {

    @Select("SELECT * FROM AuthUser WHERE openId = #{id} and authType=#{authType}")
    AuthUser getByOpenId(@Param("id")String id,@Param("authType") int authType);

    @Select("SELECT * FROM Student ")
    ArrayList<AuthUser> getAll();

    @Insert("Insert into AuthUser (userId,openId,authType,createTime)   values(#{userId},#{openId},#{authType},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="authUserId")
    int Insert(AuthUser authUser);

}

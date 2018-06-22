package com.zmx.dao;

import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public  interface BookUserMapper {


    @Select("SELECT * FROM Book WHERE Bookid = #{id}")
    SysUser getById(int id);

    @Insert("Insert into Userbook(userId,bookId) values(#{userId},#{bookId})")
    @Options(useGeneratedKeys=true,  keyProperty = "bookUserId", keyColumn = "bookUserId")
    int Insert(BookUser bookUser);


}

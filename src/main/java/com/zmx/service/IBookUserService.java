package com.zmx.service;

import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface IBookUserService {

    SysUser getById(int id);


    int Insert(BookUser Book);
}

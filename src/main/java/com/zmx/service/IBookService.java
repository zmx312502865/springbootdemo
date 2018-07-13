package com.zmx.service;

import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface IBookService {

    Book getById(int id);
    Book Insert(Book book, int userId) throws Exception;
    ArrayList<Book> getByUserId(int userId);
}

package com.zmx.service;

import com.zmx.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("BookSercvices")
public class BookSercvices  implements IBookService{

    @Autowired
    private com.zmx.dao.BookMapper sysUserMapper;

    @Override
    public Book getById(int id) {
        return sysUserMapper.getById(id);
    }

    @Override
    public int Insert(Book book) {
        return sysUserMapper.Insert(book);
    }

    @Override
    public ArrayList<Book> getByUserId(int userId) {
        return sysUserMapper.getByUserId(userId);
    }
}

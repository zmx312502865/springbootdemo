package com.zmx.service;

import com.zmx.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

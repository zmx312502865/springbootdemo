package com.zmx.service;

import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import com.zmx.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BookUserService")
public class BookUserService implements IBookUserService {

    @Autowired
    private com.zmx.dao.BookUserMapper bookUserMapper;
    @Override
    public SysUser getById(int id) {
        return bookUserMapper.getById(id);
    }


    @Override
    public int Insert(BookUser book) {
        return bookUserMapper.Insert(book);
    }
}

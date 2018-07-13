package com.zmx.service;

import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("BookSercvices")
public class BookSercvices  implements IBookService{

    @Autowired
    private com.zmx.dao.BookUserMapper bookUserMapper;

    @Autowired
    private com.zmx.dao.BookMapper bookMapper;

    @Override
    public Book getById(int id) {
        return bookMapper.getById(id);
    }

    @Override
    public Book Insert(Book book,int userId) throws Exception {
        if(book==null)
        {
            throw new Exception("book 不能为空");
        }
        if(book.getBookName().isEmpty()|| book.getBookName()==null)
        {
          throw new Exception("bookName 不能为空");
        }
        //验证
        bookMapper.Insert(book);
        BookUser bu=new BookUser();
        bu.setBookId(book.getBookId());
        bu.setUserId(userId);
        bookUserMapper.Insert(bu);
        return book;
    }
    @Override
    public ArrayList<Book> getByUserId(int userId) {
        return bookMapper.getByUserId(userId);
    }
}

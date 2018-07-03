package com.zmx.dao;

import com.zmx.entity.Book;
import com.zmx.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
public interface BookMapper {
    @Select("SELECT * FROM book WHERE bookid = #{id}")
    Book getById(int id);

    @Select("Select  b.* from userbook ub" +
             "  left join  book  b  on ub.bookid=b.bookid  " +
            "   left join sysuser u on ub.userid=u.userid   where ub.userId=#{userId}")
    ArrayList<Book> getByUserId(int userId);


    @Insert("Insert into book(bookName,bookAuthor,bookAuthorIntro,bookPubdate,bookISBN,bookSummary,bookImageUrl) values(#{bookName},#{bookAuthor},#{bookAuthorIntro},#{bookPubdate},#{bookISBN},#{bookSummary},#{bookImageUrl})")
    @Options(useGeneratedKeys=true,  keyProperty = "bookId", keyColumn = "bookId")
    int Insert(Book Book);

}

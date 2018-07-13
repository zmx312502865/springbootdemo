package com.zmx.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Book {


    private   int bookId;
    private   String bookName;
    private   String bookSummary;
    private   String bookAuthor;
    private   String bookAuthorIntro;
    private String bookPubdate;
    private   String bookISBN;
    private   String bookImageUrl;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthorIntro() {
        return bookAuthorIntro;
    }

    public void setBookAuthorIntro(String bookAuthorIntro) {
        this.bookAuthorIntro = bookAuthorIntro;
    }

    public String getBookPubdate() {
        return bookPubdate;
    }

    public void setBookPubdate(String bookPubdate) {
        this.bookPubdate = bookPubdate;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }
}

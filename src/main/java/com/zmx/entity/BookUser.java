package com.zmx.entity;

public class BookUser {
    public int getBookUserId() {
        return bookUserId;
    }

    public void setBookUserId(int bookUserId) {
        this.bookUserId = bookUserId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private   int  bookUserId;
    private   int  bookId;
    private   int  userId;
}

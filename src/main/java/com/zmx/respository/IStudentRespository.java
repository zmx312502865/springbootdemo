package com.zmx.respository;

import com.zmx.entity.Student;

import java.util.ArrayList;

public interface IStudentRespository {

    Student getById(int id);
    ArrayList<Student> getAll();
}

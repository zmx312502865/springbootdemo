package com.zmx.service;

import com.zmx.entity.Student;

import java.util.ArrayList;

public interface IStudentService  {

    Student getById(int id);

    ArrayList<Student> getAll();
}

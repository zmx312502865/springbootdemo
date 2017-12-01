package com.zmx.service;

import com.zmx.respository.IStudentRespository;
import com.zmx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("StudentService")
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRespository _studentRespository;

    public ArrayList<Student> getAll() {
        return _studentRespository.getAll();
    }

    public Student getById(int id) {
        return _studentRespository.getById(id);
    }

}

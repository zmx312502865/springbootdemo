package com.zmx.respository;

import com.zmx.dao.StudentMapper;
import com.zmx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("StudentRespository")
public class StudentRespository implements IStudentRespository {

    @Autowired
     private  StudentMapper StudentMapper;

    @Override
    public Student getById(int id) {

        return StudentMapper.getById(id);
    }

    @Override
    public ArrayList<Student> getAll() {
        return StudentMapper.getAll();
    }
}

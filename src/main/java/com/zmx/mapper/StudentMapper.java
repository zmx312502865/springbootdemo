package com.zmx.mapper;

import com.zmx.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface StudentMapper {

    @Select("SELECT * FROM Student WHERE studentID = #{id}")
    Student selectStudent(int id);

    @Select("SELECT * FROM Student ")
    ArrayList<Student> getAll();
}

package com.zmx.respository;

import com.zmx.util.SqlSessionFactoryUtil;
import com.zmx.dao.StudentMapper;
import com.zmx.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("StudentRespository")
public class StudentRespository implements IStudentRespository {

//    @Autowired
//    private SqlSession sqlSession;

//    private StudentMapper getMapper() {
//        return this.sqlSession.getMapper(StudentMapper.class);
//    }

    @Override
    public Student getById(int id) {

        return SqlSessionFactoryUtil.getSession().getMapper(StudentMapper.class).getById(id);
    }

    @Override
    public ArrayList<Student> getAll() {
        return SqlSessionFactoryUtil.getSession().getMapper(StudentMapper.class).getAll();
    }
}

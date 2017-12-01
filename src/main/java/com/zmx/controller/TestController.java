package com.zmx.controller;

import com.zmx.entity.Student;
import com.zmx.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public Object index() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
       // String statement = "test.mybatis.StudentMapper.getUser";//映射sql的标识字符串 //执行查询返回一个唯一user对象的sql User user = session.selectOne(statement, "1123");
       // Student user = session.selectOne(statement);

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student=mapper.selectStudent(3);
        ArrayList<Student> studentList=mapper.getAll();

         Logger logger = Logger.getLogger(TestController.class.getName());
        // System.out.println("This is println message.");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        return studentList;
    }


}


package com.zmx.controller;

import com.zmx.service.IStudentService;
import com.zmx.entity.Student;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired(required=true)
    private IStudentService _studentService;


    @RequestMapping("/hello")
    public Object index() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactoryUtil sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession session = sqlSessionFactory.openSession();
//
//        StudentMapper mapper = session.getMapper(StudentMapper.class);
//        Student student=mapper.getById(3);
        ArrayList<Student> studentList = _studentService.getAll();

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


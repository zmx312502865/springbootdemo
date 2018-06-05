package com.zmx.controller;

import com.zmx.service.IStudentService;
import com.zmx.entity.Student;

import com.zmx.util.MyConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/zmx")
public class TestController {
    @Autowired(required=true)
    private IStudentService _studentService;
    @Autowired
    private MyConfig myConfig;
    @RequestMapping( value = "/hello",method = RequestMethod.GET)
    public Object index() throws IOException {
        ArrayList<Student> studentList = _studentService.getAll();
        Logger logger = Logger.getLogger(TestController.class.getName());
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        return studentList;
    }

//    @RequestMapping("wz")
//    public void getIcon( HttpServletRequest request,
//                        HttpServletResponse response) throws IOException {
////        String fileName = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/classes/image/IMG_0597.PNG";
//        String fileName = TestController.class.getClassLoader().getResource("image/IMG_0597.PNG").getFile();
//        File file = new File(fileName);
//        FileInputStream inputStream = new FileInputStream(file);
//        byte[] data = new byte[(int)file.length()];
//        int length = inputStream.read(data);
//        inputStream.close();
//        response.setContentType("image/png");
//        OutputStream stream = response.getOutputStream();
//        stream.write(data);
//        stream.flush();
//        stream.close();
//    }
}


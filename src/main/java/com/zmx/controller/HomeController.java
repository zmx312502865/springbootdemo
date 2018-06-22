package com.zmx.controller;

import com.zmx.util.MyConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;


@Controller
@RequestMapping("/zmx")
public class HomeController {

    @Autowired
    private MyConfig myConfig;
    @RequestMapping( value = "/hello",method = RequestMethod.GET)
    public Object index() throws IOException {

        Logger logger = Logger.getLogger(HomeController.class.getName());
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        return "hello";
    }

}


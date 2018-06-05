package com.zmx;


import com.zmx.controller.TestController;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//@Controller
//@EnableAutoConfiguration
//@ComponentScan("com.zmx")
//@ServletComponentScan
//public class DemoApplication {
//
//    @RequestMapping("/")
//    @ResponseBody
//    public Object home( HttpServletRequest request,String id) {
//        JgwMongdb jgwMongdb=new JgwMongdb();
//        List<PICodeFont> list= jgwMongdb.getTest();
//        return list;
//    }
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//}
@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ServletComponentScan
@ComponentScan("com.zmx")
public class DemoApplication extends SpringBootServletInitializer{
    @RequestMapping("/")
//    @ResponseBody
   public String home( HttpServletRequest request,String id) {
        Logger logger = Logger.getLogger(TestController.class.getName());
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        return "hello world";
//        return "Welcome to my website    ---By Joker";
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
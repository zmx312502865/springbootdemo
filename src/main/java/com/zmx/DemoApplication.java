package com.zmx;

import com.company.JgwMongdb;
import com.company.PICodeFont;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@EnableAutoConfiguration
@ComponentScan("com.zmx")
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    public Object home( HttpServletRequest request,String id) {
        JgwMongdb jgwMongdb=new JgwMongdb();
        List<PICodeFont> list= jgwMongdb.getTest();
        return list;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}
//@Controller
//@EnableAutoConfiguration
//@SpringBootApplication
//public class DemoApplication extends SpringBootServletInitializer{
//    @RequestMapping("/")
//    @ResponseBody
//    String home( HttpServletRequest request,String id) {
////        JgwMongdb jgwMongdb=new JgwMongdb();
////        List<PICodeFont> list= jgwMongdb.getTest();
//        return "Welcome to my website    ---By Joker";
//    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DemoApplication.class);
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//}
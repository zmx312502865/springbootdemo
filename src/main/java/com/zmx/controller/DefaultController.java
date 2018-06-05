package com.zmx.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/student")
public class DefaultController {

    @RequestMapping("/")
    public   String home() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("张三", 1);
        hashMap.put("张三1", 12);
        hashMap.put("张三", 1);
        return "hello";
    }
    @RequestMapping("/hello/{myName}")
    public String index(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }
}
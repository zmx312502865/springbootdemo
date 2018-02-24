package com.zmx.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@ResponseBody
@RequestMapping("/Default")
@EnableAutoConfiguration
public class DefaultController {

    @RequestMapping("/")
    String home() {

        Test();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("张三", 1);
        hashMap.put("张三1", 12);
        hashMap.put("张三", 1);
        Integer te = hashMap.get("张三");
        Test();
        return "Hello World!";
    }

    private void Test() {

        Integer k = 3;
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }
}
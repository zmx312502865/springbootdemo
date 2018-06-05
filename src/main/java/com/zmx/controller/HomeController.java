package com.zmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/lin")
public class HomeController {
    @RequestMapping("/feifei")
    public   String home() {
        return "hello";
    }
}

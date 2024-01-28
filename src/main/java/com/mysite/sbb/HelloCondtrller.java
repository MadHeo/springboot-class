package com.mysite.sbb;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloCondtrller {
    @GetMapping("/getHello")
    @ResponseBody
    public String getHello() {
        return "Hello GET(12)";

    }

    @PostMapping("/postHello")
    @ResponseBody
    public String postHello() {
        return "Hello POST";
    }

    @GetMapping("/jump")
    @ResponseBody
    public String book() {
        return "점프 투 스프링 부트";

    }
}

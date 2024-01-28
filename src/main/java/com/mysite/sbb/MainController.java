package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    // @ResponseBody가 있으면 리턴값을 호출
    // @ResponseBody가 없으면 리턴값에 대한 페이지를 호출
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "index";
    }
}

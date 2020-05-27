package com.JSG.JSGApplication;


import net.minidev.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSOutput;

@RestController
public class HelloWorld {




    @RequestMapping("/index")
    public String index(){
        return "Hi";
    }
}

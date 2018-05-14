package com.example.demo.controller;

import com.example.demo.service.SchedualService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/2.
 */
@RestController
public class HiController {

    @Resource
    private SchedualService schedualService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET )
    public String SayHi(@RequestParam(value = "name") String name){
        System.out.println("----");
        return schedualService.sayHiFromClient(name);
    }

}

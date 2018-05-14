package com.example.demo.service;

import com.example.demo.service.hystric.SchedualServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/4/2.
 */
@FeignClient(value = "demo-cloud-client",fallback = SchedualServiceHystric.class)
public interface SchedualService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);

}

package com.example.demo.service.hystric;

import com.example.demo.service.SchedualService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/4/2.
 */
@Component
public class SchedualServiceHystric implements SchedualService {

    @Override
    public String sayHiFromClient(String name){

        return "sorry "+name+"我是feign断路器";
    }

}

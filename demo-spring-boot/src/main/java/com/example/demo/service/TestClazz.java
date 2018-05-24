package com.example.demo.service;

/**
 * Created by Administrator on 2018/5/22.
 */
public interface TestClazz {

    /**
     * 测试方法
     * @param str
     */
    default void outStr(String str){
        System.out.println(str);
    }

}

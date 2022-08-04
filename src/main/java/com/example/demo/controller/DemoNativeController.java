package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class DemoNativeController {

    private final UserMapper userMapper;

    //通过构造函数注入userMapper，通过resource注解无法注入
    public DemoNativeController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/test")
    String testRestApi() {
        return "success";
    }

    @GetMapping("/insert/{name}")
    String insert(@PathVariable("name") String name) {
        try {
            if (null != userMapper.select(name)) {
                return "duplicate";
            }
            userMapper.insert(name);
        } catch (Exception e) {
            //检查是否注入userMapper
            if (userMapper == null) {
                return "null";
            }
            return "failed";
        }
        return "success";
    }

    @GetMapping("/get/{name}")
    User select(@PathVariable("name") String name) {
        return userMapper.select(name);
    }

    @GetMapping("/delete/{name}")
    String delete(@PathVariable("name") String name) {
        try {
            userMapper.delete(name);
            return "sucess";
        } catch (Exception e) {
            return "failed";
        }
    }
}

package com.leonning.docerdemo.controller;

import com.leonning.docerdemo.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leon廖嘉宁
 * @date 2021/09/10
 * @description 描述信息
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/")
    public String home() {
        return monitorService.getInfo();
    }
}
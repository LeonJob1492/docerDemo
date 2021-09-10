package com.leonning.docerdemo.controller;

import com.leonning.docerdemo.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @author Leon廖嘉宁
 * @date 2021/09/10
 * @description 描述信息
 */
@Slf4j
@Service
public class Initializing implements InitializingBean {

    @Autowired
    private MonitorService monitorService;

    @Override
    public void afterPropertiesSet() throws Exception {
        monitorService.addCount();
    }

    @PreDestroy
    public void destroys() {
        log.info("程序被销毁");
        monitorService.reduce();
    }
}
package com.leonning.docerdemo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.leonning.docerdemo.bean.Monitor;
import com.leonning.docerdemo.dao.MonitorRepository;
import com.leonning.docerdemo.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Leon廖嘉宁
 * @date 2021/09/10
 * @description 描述信息
 */
@Transactional
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    private volatile Integer index=0;

    @Override
    public void addCount(){
        if (monitorRepository.getFirstById()==null) {
            Monitor monitor = new Monitor();
            monitor.setDockerCount(1);
            index=1;
            monitorRepository.save(monitor);
        }else {
            Monitor monitor = monitorRepository.getFirstById();
            Integer dockerCount = monitor.getDockerCount();
            index=dockerCount+1;
            monitor.setDockerCount(dockerCount+1);
            monitorRepository.save(monitor);
        }
    }

    @Override
    public void reduce(){
        Monitor monitor = monitorRepository.getFirstById();
        monitor.setDockerCount(monitor.getDockerCount()-1);
        index=0;
        monitorRepository.save(monitor);

    }
    @Override
    public String getInfo(){
        Monitor monitor = monitorRepository.getFirstById();
        Integer dockerCount = monitor.getDockerCount();
        return StrUtil.format("当前运行容器总数为{}个，当前访问机器序号为{}。",dockerCount,index);
    }
}
package com.leonning.docerdemo.dao;

import com.leonning.docerdemo.bean.Monitor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Leon廖嘉宁
 * @date 2021/09/10
 * @description 描述信息
 */
public interface MonitorRepository extends BaseRepository<Monitor, Long> {

    /**
     * fa
     * @return monitor
     */
    @Query(nativeQuery = true,value = "select * from t_sys_monitor order by id limit 1")
    Monitor getFirstById();

}
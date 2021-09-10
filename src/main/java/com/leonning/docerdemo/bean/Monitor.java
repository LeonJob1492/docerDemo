package com.leonning.docerdemo.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @author Leon廖嘉宁
 * @date 2021/09/10
 * @description 监控器 监控docker数量
 */
@Data
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Entity(name = "t_sys_monitor")
@Table(appliesTo = "t_sys_monitor", comment = "监视器")
public class Monitor extends BaseEntity{

    /**
     * 机器总数
     * */
    private Integer dockerCount;

}
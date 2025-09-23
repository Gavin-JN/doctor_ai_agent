package com.atguigu.java.ai.langchain4j.service;

import com.atguigu.java.ai.langchain4j.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.annotation.Configuration;


public interface AppointmentService extends IService<Appointment> {
    /**
     * 获取挂号信息
     * @param appointment
     * @return
     */
    Appointment getOne(Appointment appointment);


}

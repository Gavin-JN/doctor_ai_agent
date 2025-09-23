package com.atguigu.java.ai.langchain4j.tools;

import com.atguigu.java.ai.langchain4j.entity.Appointment;
import com.atguigu.java.ai.langchain4j.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentTools {

    @Autowired
    private AppointmentService appointmentService;

    @Tool(name = "book_appointment",value = "根据参数，先执行工具方法queryDepartment查询是否可预约，并直接给用户回答是否可以预约，并让用户确认所有预约信息，用户确认后再进行预约,如果用户没有提供具体的医生姓名，青葱向量存储中找到一位医生")
    public String bookAppointment(Appointment appointment) {

        //查找数据库中是否包含对应的预约记录
        Appointment appointmentDB = appointmentService.getOne(appointment);

        if(appointmentDB == null) {
            appointment.setId((null));//防止大模型幻觉设置了id
            if(appointmentService.save(appointment)){
                return "预约成功，并返回预约详情";
            }else {
                return "预约失败";
            }
        }
        return "您在相同的科室和时间已有预约";
    }

    @Tool(name = "cancel_appointment",value = "根据参数，查询预约是否存在，如果存在则删除预约记录并返回取消预约成功，否则返回取消预约失败")
    public String cancelAppointment(Appointment appointment) {
        Appointment appointmentDB = appointmentService.getOne(appointment);

        if(appointmentDB != null) {
            if(appointmentService.removeById(appointmentDB.getId())) {
                return "取消预约成功";
            }else {
                return "取消预约失败";
            }
        }
        return "您没有预约记录请核对预约科室和时间";
    }

    @Tool(name = "query_department",value = "根据科室名称，日期，时间和医生查询是否有号源，并返回给用户")
    public boolean queryDepartment(
            @P(value = "科室名称") String name,
            @P(value = "日期") String date,
            @P(value = "时间，可选值：上午，下午")String time,
            @P(value = "医生名称") String doctorName
    ){
        System.out.println("查询是否有号源");
        System.out.println("科室名称："+name);
        System.out.println("日期："+date);
        System.out.println("时间"+time);
        System.out.println("医生名称："+doctorName);

        //TODO 维护医生的排班信息；
        //如果没有指定医生名称，则根据起跳条件查询是否有可以预约的医生（有返回true,无返回false）；

        //如果指定了医生名称，则判断医生是否有排班（没有返回false);
        //如果有排班，则判断医生排班时间是否已约满（约满返回false，有空闲时间返回true）

        return true;
    }

}

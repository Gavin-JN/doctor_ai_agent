package com.atguigu.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {
//    /**
//     * sum
//     * @param a
//     * @param b
//     * @return
//     */
//    @Tool
//    double sun(double a, double b){
//        System.out.println("调用加法运算");
//        return a+b;
//    }

    @Tool(name = "sum",value = "返回两个参数的相加之和")
    double sun(
            @ToolMemoryId int memoryId,  //获取memoryId
            @P(value = "加数1",required = true)double a,
            @P(value = "加数2",required = true)double b
    ){
        System.out.println("调用加法运算"+memoryId);
        return a+b;
    }

    /**
     * square
     * @param x
     * @return
     */
    @Tool
    double squareRoot(double x){
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }

}

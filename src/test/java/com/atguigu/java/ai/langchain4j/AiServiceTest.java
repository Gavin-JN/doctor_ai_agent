package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.model.openai.OpenAiChatModel;

import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void test() {
        //创建接口对象
        Assistant assistant= AiServices.create(Assistant.class,openAiChatModel);
        String answer=assistant.chat("你好");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistant() {

        String answer=assistant.chat("你好");
        System.out.println(answer);
    }

}

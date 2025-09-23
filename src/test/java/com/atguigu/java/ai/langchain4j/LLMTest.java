package com.atguigu.java.ai.langchain4j;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private OllamaChatModel ollamaChatModel;


    interface Assistant {

        String chat(@MemoryId int memoryId, @UserMessage String userMessage);
    }


    @Test
    public void testGPTDemo(){

        OpenAiChatModel model= OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();



        //向模型提问
        String answer=model.chat("你好");
        //输出结果
        System.out.println(answer);
    }

    @Test
    public void testSpringBoot(){
        String answer=openAiChatModel.chat("你好");
        System.out.println(answer);

    }

    //测试ollama
    @Test
    public void testOllamaDemo(){
        String answer=ollamaChatModel.chat("你是谁");
        System.out.println(answer);
    }
}

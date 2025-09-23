package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import com.atguigu.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.atguigu.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

@SpringBootTest
@TestPropertySource(properties = {
        "langchain4j.open-ai.chat-model.base-url=https://api.deepseek.com/v1",
        "langchain4j.open-ai.chat-model.api-key=sk-0c318da43c77434cb402b1159a99bfad",
        "langchain4j.open-ai.chat-model.model-name=deepseek-chat",
        "spring.data.mongodb.uri=mongodb://localhost:27017/chat_memory_db"
})
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void test() {

        String answer = assistant.chat("我是小明");

        System.out.println(answer);

        String answer2 = assistant.chat("我是谁");

        System.out.println(answer2);

    }

    @Test
    public void test2() {
        UserMessage userMessage = UserMessage.userMessage("我的名字是小明");
        ChatResponse chatResponse = openAiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        System.out.println(aiMessage.text());

        UserMessage userMessage2 = UserMessage.userMessage("我叫什么名字");
        ChatResponse chatResponse2 = openAiChatModel.chat(Arrays.asList(userMessage, aiMessage, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        System.out.println(aiMessage2.text());
    }

    @Test
    public void test3() {
        // 创建一个记忆对象
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant1 = AiServices.builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(chatMemory)
                .build();

        String answer1 = assistant1.chat("我的名字是 魔丸");
        System.out.println(answer1);

        String answer2 = assistant1.chat("我的名字是什么");
        System.out.println(answer2);
    }

    @Test
    public void test4() {
        System.out.println(memoryChatAssistant.chat("我的名字是 灵珠"));
        System.out.println(memoryChatAssistant.chat("我的名字是什么"));
    }

    @Test
    public void test5() {
        System.out.println(separateChatAssistant.chat(1, "我的名字是魔丸"));
        System.out.println(separateChatAssistant.chat(1, "我的名字是什么"));
        System.out.println(separateChatAssistant.chat(2, "我的名字是什么"));
    }

    @Test
    public void test5_2(){
        System.out.println(separateChatAssistant.chat(1,"我的名字是什么"));
    }

    @Test
    public void test6() {
        System.out.println(separateChatAssistant.chat(3,"今天是几号"));
    }

    @Test
    public void test7() {
        System.out.println(memoryChatAssistant.chat("我是魔丸"));
    }

}

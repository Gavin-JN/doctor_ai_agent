package com.atguigu.java.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        "langchain4j.open-ai.chat-model.base-url=https://api.deepseek.com/v1",
        "langchain4j.open-ai.chat-model.api-key=sk-0c318da43c77434cb402b1159a99bfad",
        "langchain4j.open-ai.chat-model.model-name=deepseek-chat",
        "spring.data.mongodb.uri=mongodb://localhost:27017/chat_memory_db"
})
public class OpenAiTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testOpenAiChatModel() {
        assertNotNull(openAiChatModel, "OpenAiChatModel should not be null");
        System.out.println("OpenAiChatModel: " + openAiChatModel);
    }
}

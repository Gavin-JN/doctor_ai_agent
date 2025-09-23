package com.atguigu.java.ai.langchain4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = { com.atguigu.java.ai.langchain4j.XiaozhiApp.class }, properties = {
        "langchain4j.open-ai.chat-model.base-url=https://api.deepseek.com/v1",
        "langchain4j.open-ai.chat-model.api-key=sk-0c318da43c77434cb402b1159a99bfad",
        "langchain4j.open-ai.chat-model.model-name=deepseek-chat",
        "spring.data.mongodb.uri=mongodb://localhost:27017/chat_memory_db"
})
public class SpringContextTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testSpringContext() {
        assertNotNull(applicationContext, "ApplicationContext should not be null");
        System.out.println("ApplicationContext: " + applicationContext);

        // 检查是否有 OpenAiChatModel bean
        try {
            Object openAiChatModel = applicationContext.getBean("openAiChatModel");
            System.out.println("OpenAiChatModel bean: " + openAiChatModel);
        } catch (Exception e) {
            System.out.println("OpenAiChatModel bean not found: " + e.getMessage());
        }

        // 检查所有 bean 名称
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("All bean names:");
        for (String beanName : beanNames) {
            if (beanName.contains("openai") || beanName.contains("chat") || beanName.contains("langchain")) {
                System.out.println("  " + beanName);
            }
        }
    }
}

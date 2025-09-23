package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(chatModel = "openAiChatModel")
public interface Assistant {

    String chat(String userMessage);

    // ChatResponse chat(UserMessage userMessage);
}

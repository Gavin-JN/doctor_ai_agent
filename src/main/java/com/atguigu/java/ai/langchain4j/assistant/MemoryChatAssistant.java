package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(chatModel = "openAiChatModel", chatMemory = "chatMemory")
public interface MemoryChatAssistant {

    @UserMessage("你是我的好朋友，请用上海话回答问题，并添加一些表情符号。{{it}}")  //{{it}}表示这里唯一的占位符
    String chat(String message);
}

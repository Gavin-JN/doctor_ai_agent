package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(chatModel = "openAiChatModel", chatMemoryProvider = "chatMemoryProvider",tools = "calculatorTools" // 实现会话隔离
)
public interface SeparateChatAssistant {
    @SystemMessage("你是我的好朋友，请用东北话回答")
    String chat(@MemoryId int memoryId, @UserMessage String message);

    //也可以添加提示模版如 @SystemMessage(fromResource-"my-prompt-template.txt")

//    @UserMessage("你是我的好朋友，请用东北话回答. {{message}}")
//    String chat(@MemoryId int memoryId, @V("message") String message);


}

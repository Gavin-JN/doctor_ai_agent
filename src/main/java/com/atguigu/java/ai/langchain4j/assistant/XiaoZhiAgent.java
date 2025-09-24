package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(chatModel = "qwenStreamingChatModel",//大模型
        chatMemoryProvider = "chatMemoryProviderXiaoZhi",//实现聊天隔离
        tools = "appointmentTools",//方法调用
        contentRetriever = "contentRetrieverXiaozhiPinecone"//配置向量存储 RAG
)
public interface XiaoZhiAgent {

    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}

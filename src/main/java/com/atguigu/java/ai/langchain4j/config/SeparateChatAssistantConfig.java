//package com.atguigu.java.ai.langchain4j.config;
//
//import com.atguigu.java.ai.langchain4j.store.MongoChatMemoryStore;
//import dev.langchain4j.memory.chat.ChatMemoryProvider;
//import dev.langchain4j.memory.chat.MessageWindowChatMemory;
//import dev.langchain4j.store.memory.chat.ChatMemoryStore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SeparateChatAssistantConfig {
//
//    @Autowired
//    private MongoChatMemoryStore chatMemoryStore;
//
//    @Bean
//    public ChatMemoryProvider chatMemoryProvider() {
//        return memoryId -> MessageWindowChatMemory.builder()
//                .id(memoryId)
//                .maxMessages(10)
//                .chatMemoryStore(chatMemoryStore)  //配置持久化对象
//                .build();
//    }
//}
////
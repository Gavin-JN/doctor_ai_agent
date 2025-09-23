package com.atguigu.java.ai.langchain4j.config;

import com.atguigu.java.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2q.AllMiniLmL6V2QuantizedEmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
//import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.List;

@Configuration
public class XiaoZhiAgentConfig {

    @Autowired
    private MongoChatMemoryStore chatMemoryStore;

    @Autowired
    private  EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore embeddingStore;

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(chatMemoryStore)
                .build();
    }

//    @Bean
//    ContentRetriever contentRetrieverXiaozhi() {
//        Document document1 = FileSystemDocumentLoader
//                .loadDocument("D:\\AI-Project\\java-ai-langchain4j\\src\\main\\resources\\pumch_knowledge_full.txt");
//        Document document2 = FileSystemDocumentLoader
//                .loadDocument("D:\\AI-Project\\java-ai-langchain4j\\src\\main\\resources\\doctors.txt");
//        List<Document> documents = Arrays.asList(document1, document2);
//
//        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
//
//        // 👇 显式创建 EmbeddingModel
//        EmbeddingModel embeddingModel = new AllMiniLmL6V2QuantizedEmbeddingModel();
//
//        // 👇 用 builder 构造 ContentRetriever，显式传入 embeddingModel
//        EmbeddingStoreContentRetriever retriever = EmbeddingStoreContentRetriever.builder()
//                .embeddingStore(embeddingStore)
//                .embeddingModel(embeddingModel) // ⭐⭐⭐ 关键：显式指定，避免自动发现冲突
//                .maxResults(5) // 可选：设置返回 top K 片段
//                .minScore(0.5) // 可选：设置最低相似度阈值
//                .build();
//
//        // 👇 用同一个 embeddingModel 来做文档嵌入
//        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
//                .embeddingModel(embeddingModel)
//                .embeddingStore(embeddingStore)
//                .build();
//
//        ingestor.ingest(documents);
//
//        return retriever; // ✅ 返回显式配置好的 retriever
//    }

    ContentRetriever contentRetrieverXiaozhiPinecone() {

        //创建一个 EmbeddingStoreContentRetriever 对象，用于从嵌入存储中检索内容
        return EmbeddingStoreContentRetriever
                .builder()
                //设置用于生成嵌入向量的嵌入模型
                .embeddingModel(embeddingModel)
                //指定要使用的嵌入存储
                .embeddingStore(embeddingStore)
                //设置最大检索结果数量，这里表示最多返回1条匹配结果
                .maxResults(1)
                //设置最小得分阈值，只有得分大于等于0.8的结果才返回
                .minScore(0.8)
                //构件最终的 EmbeddingStoreContentRetriever
                .build();
    }

}

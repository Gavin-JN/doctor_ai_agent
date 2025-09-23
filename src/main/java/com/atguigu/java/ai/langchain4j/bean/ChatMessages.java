package com.atguigu.java.ai.langchain4j.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {

    //唯一标识，映射到MongDB 文档的 _id 字段
    @Id
    private ObjectId id;

    private int messageId;

    private String content;  //存储当前聊天记录列表的JSON字符串


}

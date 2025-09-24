package com.atguigu.java.ai.langchain4j.bean;

import lombok.Data;

@Data
public class ChatForm {
    private Long memoryId;  //对话id
    private String message;  //用户问题

    public Long getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(Long memoryId) {
        this.memoryId = memoryId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.atguigu.java.ai.langchain4j.controller;

import com.atguigu.java.ai.langchain4j.assistant.XiaoZhiAgent;
import com.atguigu.java.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*")
@Tag(name="硅谷小智")
@RestController
@RequestMapping("/xiaozhi")

public class XiaoZhiController {

    @Autowired
    private XiaoZhiAgent xiaoZhiAgent;
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return xiaoZhiAgent.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }
}

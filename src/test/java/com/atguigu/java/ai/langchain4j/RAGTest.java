package com.atguigu.java.ai.langchain4j;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RAGTest {

    @Test
    public void testReadDocument(){

        Document document= FileSystemDocumentLoader.loadDocument("C:\\Users\\mao19\\Desktop\\hh.txt");
        System.out.println(document.text());

    }

}

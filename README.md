# 硅谷小智 - 基于 LangChain4j 的智能医疗助手

## 项目简介

硅谷小智是一个基于 Spring Boot 和 LangChain4j 框架开发的智能医疗助手系统，模拟北京协和医院的智能客服。该系统集成了大语言模型、RAG（检索增强生成）、工具调用和聊天记忆等功能，为用户提供医疗咨询、智能分导诊、预约挂号等服务。

## 核心功能

### 🤖 智能对话

- 基于大语言模型的自然语言对话
- 支持多轮对话和上下文记忆
- 友好的医疗顾问角色设定

### 🏥 医疗咨询

- 提供专业的医疗建议和健康咨询
- 基于临床实践和研究的准确医疗信息
- 包含病因分析、诊断流程、治疗方案等

### 🎯 AI 分导诊

- 根据患者病情和就医需求智能推荐科室
- 基于向量数据库的智能匹配

### 📅 预约挂号管理

- **智能查询号源**：检查指定科室、日期、时间的可预约情况
- **智能预约挂号**：支持完整的预约流程
- **智能取消挂号**：便捷的预约取消服务
- **预约信息管理**：支持姓名、身份证、科室、日期、时间、医生等完整信息

### 🧠 RAG 知识检索

- 基于协和医院知识库的智能检索
- 支持医生信息查询和推荐
- 向量化存储和语义搜索

## 技术架构

### 核心技术栈

- **Java 17** - 编程语言
- **Spring Boot 3.5.3** - 应用框架
- **LangChain4j 1.0.0-beta3** - AI 应用框架
- **MyBatis Plus 3.5.7** - 数据访问层
- **MongoDB** - 聊天记忆存储
- **MySQL** - 业务数据存储
- **Knife4j 4.3.0** - API 文档

### 大模型支持

- **DeepSeek** - 主要使用的大语言模型
- **OpenAI** - 兼容 OpenAI 标准接口
- **Ollama** - 支持本地模型部署

### 项目结构

```
src/main/java/com/atguigu/java/ai/langchain4j/
├── assistant/          # AI助手相关
│   ├── Assistant.java
│   ├── MemoryChatAssistant.java
│   ├── SeparateChatAssistant.java
│   └── XiaoZhiAgent.java
├── bean/               # 数据传输对象
│   ├── ChatForm.java
│   └── ChatMessages.java
├── config/             # 配置类
│   ├── MemoryChatAssistantConfig.java
│   ├── SeparateChatAssistantConfig.java
│   └── XiaoZhiAgentConfig.java
├── controller/         # 控制器
│   └── XiaoZhiController.java
├── entity/             # 实体类
│   └── Appointment.java
├── mapper/             # 数据访问层
│   └── AppointmentMapper.java
├── service/            # 业务逻辑层
│   ├── AppointmentService.java
│   └── impl/
│       └── AppointmentServiceImpl.java
├── store/              # 存储相关
│   └── MongoChatMemoryStore.java
├── tools/              # 工具类
│   ├── AppointmentTools.java
│   └── CalculatorTools.java
└── XiaozhiApp.java     # 启动类
```

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- MongoDB 4.4+

### 配置说明

1. **数据库配置** (application.properties)

```properties
# MySQL配置
spring.datasource.url=jdbc:mysql://localhost:3306/guiguxiaozhi?useUnicode=true&&characterEncoding=UTF-8&&serverTimezone=Asia/Shanghai&&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

# MongoDB配置
spring.data.mongodb.uri=mongodb://localhost:27017/chat_memory_db
```

2. **大模型配置**

```properties
# DeepSeek配置
langchain4j.open-ai.chat-model.base-url=https://api.deepseek.com/v1
langchain4j.open-ai.chat-model.api-key=${DEEPSEEK_KEY}
langchain4j.open-ai.chat-model.model-name=deepseek-chat
```

### 运行步骤

1. **克隆项目**

```bash
git clone <repository-url>
cd java-ai-langchain4j
```

2. **配置环境变量**

```bash
# 设置DeepSeek API Key
export DEEPSEEK_KEY=your_deepseek_api_key
```

3. **创建数据库**

```sql
CREATE DATABASE guiguxiaozhi;
```

4. **启动应用**

```bash
mvn spring-boot:run
```

5. **访问应用**

- 应用地址：http://localhost:8080
- API 文档：http://localhost:8080/doc.html

## API 接口

### 对话接口

```http
POST /xiaozhi/chat
Content-Type: application/json

{
    "memoryId": 123,
    "message": "我想预约心内科的号"
}
```

**响应示例：**

```json
{
  "code": 200,
  "message": "您好！我是硅谷小智，北京协和医院的智能客服助手。我可以帮您预约心内科的号源，请提供您的姓名、身份证号、预约日期和时间。"
}
```

## 核心特性

### 1. 智能预约流程

- 自动查询号源可用性
- 智能推荐合适医生
- 完整的预约信息验证
- 支持预约取消和修改

### 2. 多模态记忆管理

- 基于 MongoDB 的持久化聊天记忆
- 支持多用户会话隔离
- 智能上下文管理

### 3. 知识库集成

- 协和医院专业知识库
- 医生信息数据库
- 向量化检索和匹配

### 4. 工具调用能力

- 预约管理工具
- 计算器工具
- 可扩展的工具框架

## 开发指南

### 添加新的工具

1. 在`tools`包下创建工具类
2. 使用`@Tool`注解标记方法
3. 在`XiaoZhiAgent`接口中注册工具

### 扩展知识库

1. 将知识文档放入`resources`目录
2. 在`XiaoZhiAgentConfig`中配置文档加载
3. 重新构建向量索引

### 自定义提示词

修改`resources/zhaozhi-prompt-template.txt`文件来自定义 AI 助手的角色和行为。

## 测试

运行测试用例：

```bash
mvn test
```

主要测试类：

- `SimpleTest` - 基础功能测试
- `OpenAiTest` - 大模型接口测试
- `ChatMemoryTest` - 聊天记忆测试
- `RAGTest` - 知识检索测试

## 部署

### Docker 部署

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/java-ai-langchain4j-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 生产环境配置

- 配置生产数据库连接
- 设置合适的 JVM 参数
- 配置日志级别
- 设置安全认证

## 贡献指南

1. Fork 项目
2. 创建功能分支
3. 提交更改
4. 推送到分支
5. 创建 Pull Request

## 许可证

本项目采用 MIT 许可证。

## 联系方式

如有问题或建议，请通过以下方式联系：

- 项目 Issues
- 邮箱：[2953301585@qq.com]

---

**注意**：本项目仅用于学习和演示目的，不应用于生产环境的医疗诊断。请遵循相关医疗法规和伦理准则。

const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;

// 启用CORS，允许跨域请求
app.use(cors());

// 静态文件服务
app.use(express.static(path.join(__dirname)));

// 健康检查接口
app.get('/health', (req, res) => {
    res.json({ 
        status: 'ok', 
        message: '硅谷小智前端服务运行正常',
        timestamp: new Date().toISOString()
    });
});

// 代理API请求（可选，如果需要代理后端请求）
app.use('/api', (req, res) => {
    // 这里可以添加代理逻辑，将请求转发到后端服务
    res.status(501).json({ 
        message: 'API代理功能未配置，请直接使用后端服务地址' 
    });
});

// 所有其他请求都返回index.html（支持SPA路由）
app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html'));
});

// 启动服务器
app.listen(PORT, () => {
    console.log('🚀 硅谷小智前端服务已启动!');
    console.log(`📱 本地访问地址: http://localhost:${PORT}`);
    console.log(`🏥 服务名称: 北京协和医院智能客服`);
    console.log(`⏰ 启动时间: ${new Date().toLocaleString()}`);
    console.log('💡 提示: 请确保后端服务已启动并配置正确的API地址');
    console.log('📝 配置文件: config.js');
    console.log('----------------------------------------');
});

// 优雅关闭
process.on('SIGTERM', () => {
    console.log('🛑 收到SIGTERM信号，正在关闭服务器...');
    process.exit(0);
});

process.on('SIGINT', () => {
    console.log('🛑 收到SIGINT信号，正在关闭服务器...');
    process.exit(0);
});

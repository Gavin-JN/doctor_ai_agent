// 配置文件
const CONFIG = {
    // API配置
    API_BASE_URL: 'http://localhost:8080', // 根据您的后端服务地址修改
    CHAT_ENDPOINT: '/xiaozhi/chat',
    
    // 应用配置
    APP_NAME: '硅谷小智',
    HOSPITAL_NAME: '北京协和医院',
    
    // 功能配置
    FEATURES: {
        AUTO_WELCOME: true, // 是否自动发送欢迎消息
        TYPING_INDICATOR: true, // 是否显示打字指示器
        QUICK_ACTIONS: true, // 是否显示快速操作按钮
        MEDICAL_INFO: true // 是否显示医疗信息提示
    },
    
    // 快速操作按钮配置
    QUICK_ACTIONS: [
        { text: '头痛咨询', message: '我想咨询一下头痛的问题' },
        { text: '预约挂号', message: '我想预约挂号' },
        { text: '就医流程', message: '我想了解就医流程' },
        { text: '科室查询', message: '我想查询科室信息' },
        { text: '取消挂号', message: '我想取消挂号预约' },
        { text: '查询挂号', message: '我想查询我的挂号信息' }
    ],
    
    // 医疗信息提示
    MEDICAL_INFO: {
        title: '🏥 服务说明',
        items: [
            '💊 提供专业的医疗建议和健康咨询',
            '🎯 AI智能分导诊，推荐最适合的科室',
            '📅 智能挂号助手，预约挂号服务',
            '❓ 就医流程相关问题解答'
        ]
    }
};

// 导出配置（如果在模块环境中使用）
if (typeof module !== 'undefined' && module.exports) {
    module.exports = CONFIG;
}

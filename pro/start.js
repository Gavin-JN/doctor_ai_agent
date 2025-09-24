#!/usr/bin/env node

const { execSync } = require('child_process');
const fs = require('fs');
const path = require('path');

console.log('🏥 硅谷小智 - 北京协和医院智能客服');
console.log('=====================================');

// 检查Node.js版本
const nodeVersion = process.version;
const majorVersion = parseInt(nodeVersion.slice(1).split('.')[0]);

if (majorVersion < 14) {
    console.error('❌ 错误: 需要Node.js 14.0.0或更高版本');
    console.error(`   当前版本: ${nodeVersion}`);
    console.error('   请访问 https://nodejs.org 下载最新版本');
    process.exit(1);
}

console.log(`✅ Node.js版本检查通过: ${nodeVersion}`);

// 检查package.json是否存在
if (!fs.existsSync('package.json')) {
    console.error('❌ 错误: 未找到package.json文件');
    process.exit(1);
}

// 检查node_modules是否存在
if (!fs.existsSync('node_modules')) {
    console.log('📦 检测到首次运行，正在安装依赖...');
    try {
        execSync('npm install', { stdio: 'inherit' });
        console.log('✅ 依赖安装完成');
    } catch (error) {
        console.error('❌ 依赖安装失败:', error.message);
        process.exit(1);
    }
} else {
    console.log('✅ 依赖已安装');
}

// 检查配置文件
if (!fs.existsSync('config.js')) {
    console.log('⚠️  警告: 未找到config.js配置文件');
    console.log('   请确保已正确配置API地址');
}

console.log('🚀 启动开发服务器...');
console.log('   访问地址: http://localhost:3000');
console.log('   按 Ctrl+C 停止服务');
console.log('=====================================');

// 启动开发服务器
try {
    execSync('npm run dev', { stdio: 'inherit' });
} catch (error) {
    console.error('❌ 启动失败:', error.message);
    process.exit(1);
}

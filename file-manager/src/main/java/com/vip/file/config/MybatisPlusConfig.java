package com.vip.file.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置自动填充
 *
 * @author wgb
 * @date 2020/3/28 10:25
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 自动填充功能
     * @return
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MyBatisPlusMetaHandler());
        return globalConfig;
    }
}

/**
 * This file is part of MoChat.
 * @link     https://mo.chat
 * @document https://mochat.wiki
 * @contact  group@mo.chat
 * @license  https://github.com/mochat-cloud/mochat-java/blob/master/LICENSE
 */

package com.mochat.mochat;

import com.mochat.mochat.service.sidebar.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * MoChatApplication
 *
 */
@SpringBootApplication
public class MoChatApplication extends SpringBootServletInitializer {

    private final static Logger logger = LoggerFactory.getLogger(MoChatApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里一定要指向原先用main方法执行的Application启动类
        logger.info("MoChatApplication started!!!");
        return builder.sources(MoChatApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MoChatApplication.class, args);
    }

    /**
     * 企业微信 - 侧边栏配置文件上传服务相关初始化
     */
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> storageService.init();
    }
}

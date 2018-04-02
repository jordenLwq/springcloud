/*package com.jorden.li.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




*//**
 * **************************************************************** Java Lib For Android, Powered By jorden.li Copyright
 * (c) 2001-2014 Digital Telemedia Co.,Ltd https://jordenlwq.github.io/ Package: com.jorden.li.config Filename:
 * RabbitMQConfig.java Description: TODO(用一句话描述该文件做什么) Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia
 * Co.,Ltd
 * RabbitMQ 配置
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2018年1月5日 下午10:25:44 Revision: 2018年1月5日 下午10:25:44 - first revision
 *//*
@Configuration
public class RabbitMQConfig {

	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}
*/
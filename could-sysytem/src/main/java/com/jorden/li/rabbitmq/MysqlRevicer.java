/*package com.jorden.li.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

*//**
 * MQ监控MYSQL同步日志
 * @ClassName MysqlRevicer
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author jorden.li
 * @Date 2018年1月9日 上午9:29:42
 * @version 1.0.0
 *//*
@Component
public class MysqlRevicer {
		
	    @RabbitListener(queues = "SNY_MYSQL")
	    public void process(@Payload  byte ascii[]  ) {
		
	        System.err.println("接收到MYSQL同步信息 : " + new String(ascii));
	    }

}
*/
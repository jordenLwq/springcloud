package com.jorden.li.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jorden.li.core.DynamicDataSource;


/**
 * DataSourceConfig 配置
 * @ClassName:  DataSourceConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jorden.li
 * @date:   2018年4月2日 上午10:56:36   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * Success is never final. Failure is never fatal. Courage is what counts. -Sir Winston Churchill
 */
@Configuration
public class DataSourceConfig {
	
	@Value("${spring.datasource.type}")
	private Class < ? extends DataSource> dataSourceType;
	/**
	 * master 配置
	 * @Title: masterDataSource   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: DataSource      
	 * @throws
	 */
	@Bean(name="masterDataSource",destroyMethod="close",initMethod="init")
	@ConfigurationProperties(prefix="spring.datasource.master")
	public DataSource masterDataSource(){
		return DataSourceBuilder.create().type(dataSourceType).build();
	}
	/**
	 * slave 配置
	 * @Title: slaveDataSource   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: DataSource      
	 * @throws
	 */
	@Bean(name="slaveDataSource",destroyMethod="close",initMethod="init")
	@ConfigurationProperties(prefix="spring.datasource.slave")
	public DataSource slaveDataSource(){
		return DataSourceBuilder.create().type(dataSourceType).build();
		
	}
	@Bean(name="dataSource")
	public DataSource dataSource(){
		DynamicDataSource dataSource=new DynamicDataSource();
		  // 配置多数据源  
        Map<Object, Object> targetDataSources = new HashMap<>();  
        targetDataSources.put("master", masterDataSource());  
        targetDataSources.put("slave", slaveDataSource());  
        dataSource.setTargetDataSources(targetDataSources);  
        dataSource.setDefaultTargetDataSource(masterDataSource());  
        return dataSource;  
	}
	

}

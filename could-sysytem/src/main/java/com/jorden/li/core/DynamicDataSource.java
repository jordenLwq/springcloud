package com.jorden.li.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 
 * @ClassName:  DynamicDataSource   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jorden.li
 * @date:   2018年4月2日 上午11:14:52   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * Success is never final. Failure is never fatal. Courage is what counts. -Sir Winston Churchill
 */
public class DynamicDataSource  extends AbstractRoutingDataSource{
	
	private static final ThreadLocal<String> datasourceHolder = new ThreadLocal<>();  
	  
    @Override  
    public Object determineCurrentLookupKey() {  
        return datasourceHolder.get();  
    }  
  
    public   static void setDataSource(String sourceName) {  
        datasourceHolder.set(sourceName);  
    }  
  
    public static void clearDataSource() {  
        datasourceHolder.remove();  
        
    }  
}

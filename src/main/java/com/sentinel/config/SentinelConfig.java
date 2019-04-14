package com.sentinel.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.redis.RedisDataSource;
import com.alibaba.csp.sentinel.datasource.redis.config.RedisConnectionConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 使用 ZooKeeper配置规则 <br>
 * 版权：Copyright (c) 2016-2019<br>
 * 作者：孙常军<br>
 * 版本：1.0<br>
 * 创建日期：2019年4月12日<br>
 */
@Configuration
public class SentinelConfig {

	@Value("${datasource.zookeeper.serverAddr}")
	private String zkServerAddr;

	@Value("${datasource.zookeeper.groupId}")
	private String groupId;

	@Value("${datasource.zookeeper.flowDataId}")
	private String flowDataId;

	@Value("${datasource.zookeeper.degradeDataId}")
	private String degradeDataId;

	@Value("${datasource.zookeeper.systemDataId}")
	private String systemDataId;
	
	@Value("${datasource.redis.host}")
	private String redisHost;
	
	@Value("${datasource.redis.port}")
	private int redisPort;
	
	@Value("${datasource.redis.flowRuleKey}")
	private String flowRuleKey;
	
	@Value("${datasource.redis.channel}")
	private String channel;

	@PostConstruct
	public void loadRules() {
		/** Zookeeper */
		// // 流控规则注册
		// ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new
		// ZookeeperDataSource<>(zkServerAddr, groupId, flowDataId, source ->
		// JSON.parseObject(source,
		// new TypeReference<List<FlowRule>>() {
		// }));
		// FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
		//
		// // 降级规则注册
		// ReadableDataSource<String, List<DegradeRule>> degradeRleDataSource =
		// new ZookeeperDataSource<>(zkServerAddr, groupId, degradeDataId,
		// source -> JSON.parseObject(source,
		// new TypeReference<List<DegradeRule>>() {
		// }));
		// DegradeRuleManager.register2Property(degradeRleDataSource.getProperty());
		//
		// // 系统参数规则注册
		// ReadableDataSource<String, List<SystemRule>> systemRuleDataSource =
		// new ZookeeperDataSource<>(zkServerAddr, groupId, systemDataId, source
		// -> JSON.parseObject(source,
		// new TypeReference<List<SystemRule>>() {
		// }));
		// SystemRuleManager.register2Property(systemRuleDataSource.getProperty());

		/** Redis */
		// RedisConnectionConfig config =
		// RedisConnectionConfig.builder().withHost(redisHost).withPort(redisPort).build();
		// ReadableDataSource<String, List<FlowRule>> redisDataSource = new
		// RedisDataSource<>(config, flowRuleKey, channel, source ->
		// JSON.parseObject(source,
		// new TypeReference<List<FlowRule>>() {
		// }));
		// FlowRuleManager.register2Property(redisDataSource.getProperty());
	}

}

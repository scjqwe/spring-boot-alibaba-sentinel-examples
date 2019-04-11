//package com.sentinel.config;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//
///**
// * 使用 ZooKeeper 配置规则 <br>
// * 版权：Copyright (c) 2016-2019<br>
// * 作者：孙常军<br>
// * 版本：1.0<br>
// * 创建日期：2019年4月12日<br>
// */
//@Configuration
//public class ZookeeperDataSourceConfig {
//
//	@Value("${zookeeper.server}")
//	private String server;
//
//	@Value("${zookeeper.groudid}")
//	private String groupId;
//
//	@Value("${zookeeper.dataid}")
//	private String dataId;
//
//	@Bean
//	public ReadableDataSource<String, List<FlowRule>> zookeeperDataSource() {
//		// 规则会持久化到zk的/groupId/flowDataId节点
//		// groupId和和flowDataId可以用/开头也可以不用
//		// 建议不用以/开头，目的是为了如果从Zookeeper切换到Nacos的话，只需要改数据源类名就可以
//		ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new ZookeeperDataSource<>(server, groupId, dataId, source -> JSON.parseObject(source,
//				new TypeReference<List<FlowRule>>() {
//				}));
//		FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
//	}
//
//}

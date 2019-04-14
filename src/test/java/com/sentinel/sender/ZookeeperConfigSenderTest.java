package com.sentinel.sender;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * zookeeper规则请求测试 <br>
 * 版权：Copyright (c) 2016-2019<br>
 * 作者：孙常军<br>
 * 版本：1.0<br>
 * 创建日期：2019年4月13日<br>
 */
public class ZookeeperConfigSenderTest {
	private static final int RETRY_TIMES = 3;
	private static final int SLEEP_TIME = 1000;

	public static void main(String[] args) throws Exception {
		final String remoteAddress = "localhost:2181";
		final String groupId = "sentinel";
		final String dataId = "hello";
		final String rule = "[\n" + "  {\n" + "    \"resource\": \"TestResource\",\n" + "    \"controlBehavior\": 0,\n" + "    \"count\": 10.0,\n" + "    \"grade\": 1,\n"
				+ "    \"limitApp\": \"default\",\n" + "    \"strategy\": 0\n" + "  }\n" + "]";

		CuratorFramework zkClient = CuratorFrameworkFactory.newClient(remoteAddress, new ExponentialBackoffRetry(SLEEP_TIME, RETRY_TIMES));
		zkClient.start();
		String path = getPath(groupId, dataId);
		Stat stat = zkClient.checkExists().forPath(path);
		if (stat == null) {
			zkClient.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, null);
		}
		zkClient.setData().forPath(path, rule.getBytes());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		zkClient.close();
	}

	private static String getPath(String groupId, String dataId) {
		String path = "";
		if (groupId.startsWith("/")) {
			path += groupId;
		} else {
			path += "/" + groupId;
		}
		if (dataId.startsWith("/")) {
			path += dataId;
		} else {
			path += "/" + dataId;
		}
		return path;
	}
}

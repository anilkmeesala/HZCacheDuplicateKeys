package com.anil.hzcachetest.loader;

import java.io.IOException;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;

public class CacheClient {
	private static HazelcastInstance hzClient = null;
	public static HazelcastInstance getClient() throws IOException{
		if(hzClient!=null && !hzClient.getLifecycleService().isRunning()){
			hzClient=null;
		}
		if(hzClient==null){
			ClientConfig cfg = new XmlClientConfigBuilder("hz-client.xml").build();
			hzClient = HazelcastClient.newHazelcastClient(cfg);
		}
		return hzClient;
			
	}
	
}

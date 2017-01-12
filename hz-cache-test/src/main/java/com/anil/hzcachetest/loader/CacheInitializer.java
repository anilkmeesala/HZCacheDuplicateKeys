package com.anil.hzcachetest.loader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;

@Component
public class CacheInitializer {
	
	@Autowired
	@Qualifier("hzInstance")
	HazelcastInstance hzInstance;
	
	@PostConstruct
	public void init(){
		hzInstance.getMap("personMap");
	}

}

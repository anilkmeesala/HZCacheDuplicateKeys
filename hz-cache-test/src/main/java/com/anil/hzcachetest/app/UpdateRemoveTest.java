package com.anil.hzcachetest.app;

import java.io.IOException;

import com.anil.hzcachetest.key.PersonKey;
import com.anil.hzcachetest.loader.CacheClient;
import com.anil.hzcachetest.model.Person;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class UpdateRemoveTest {
	public static void main(String[] args) throws IOException {
		HazelcastInstance hzInstance = CacheClient.getClient();
		IMap<PersonKey, Person> personMap = hzInstance.getMap("personMap");
		PersonKey pk1 = new PersonKey();
		pk1.setId("6");
		pk1.setName("name6");//even if we uncomment - duplicate key will be inserted into the map
		//this happens in put and load also
		
//		personMap.delete(pk1);
//		personMap.get(pk1);
		
		System.out.println(personMap.keySet());
		System.out.println(personMap.values());
		
	}

}

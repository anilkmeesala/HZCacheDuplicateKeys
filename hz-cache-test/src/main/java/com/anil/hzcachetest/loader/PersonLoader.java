package com.anil.hzcachetest.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.hzcachetest.jdbc.PersonDAO;
import com.anil.hzcachetest.key.KeyUtil;
import com.anil.hzcachetest.key.PersonKey;
import com.anil.hzcachetest.model.Person;
import com.hazelcast.core.MapLoader;

/**
 * Created by anil on 1/10/2017.
 */
@Service
public class PersonLoader implements MapLoader<PersonKey,Person> {
	@Autowired
	PersonDAO personDAO;
	
	public Iterable<PersonKey> loadAllKeys() {
		List<String> ids = personDAO.getIds();
		List<PersonKey> personKeys= new ArrayList<>();
		for (String id : ids) {
			PersonKey pk = new PersonKey();
			pk.setId(id);
			personKeys.add(pk);
		}
		System.out.println("loadAllKeys: "+personKeys);
		return personKeys;
	}

	public Map<PersonKey, Person> loadAll(Collection<PersonKey> keys) {
		System.out.println("loadAll :"+keys);
		Map<PersonKey,Person> tempMap = new ConcurrentHashMap<>();
		for (PersonKey key : keys) {
			Person person = personDAO.getPerson(key.getId());
			System.out.println(person);
			tempMap.put(KeyUtil.getKey(person), person);
		}
		return tempMap;
	}



	@Override
	public Person load(PersonKey key) {
		System.out.println("load :"+key.getId());
		return personDAO.getPerson(key.getId());
	}
}

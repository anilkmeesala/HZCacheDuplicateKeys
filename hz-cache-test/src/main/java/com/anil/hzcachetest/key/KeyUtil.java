package com.anil.hzcachetest.key;

import com.anil.hzcachetest.model.Person;

public class KeyUtil {

	public static PersonKey getKey(Person person) {
		PersonKey pk = new PersonKey();
		pk.setId(person.getId());
		pk.setName(person.getName());
		return pk;
	}

}

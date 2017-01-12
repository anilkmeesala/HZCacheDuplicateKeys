package com.anil.hzcachetest.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anil.hzcachetest.jdbc.PersonDB;

public class App {
	public static void main(String[] args) {
		PersonDB.createTable();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	}

}

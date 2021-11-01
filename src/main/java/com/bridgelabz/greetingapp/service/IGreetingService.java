package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService 
{
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getGreetingList();
	Greeting editGreeting(String name1,String name2);
	List<Greeting> deleteGreeting(String name);

}

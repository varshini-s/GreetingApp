package com.bridgelabz.greetingapp.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService
{
	private static final String template="Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private GreetingRepository greetingRepository;
    
	@Override
	public Greeting addGreeting(User user) 
	{
		String message=String.format(template,(user.toString().isEmpty())?"HEllo world":user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	}

	@Override
	public Greeting getGreetingById(long id) 
	{
		
		return greetingRepository.findById(id).get();
	}
	
	@Override
	public List<Greeting> getGreetingList()
	{
		return greetingRepository.findAll();		
		
	}
	
	@Override
	public Greeting editGreeting(String name1,String name2)
	{
		List<Greeting> greetingList=greetingRepository.findAll();
		Greeting greetingToEdit = null;
		for(int index=0;index<greetingList.size();index++)
		{
			if(greetingList.get(index).getMessage().contains(name1))
			{
				greetingToEdit=greetingList.get(index);
				break;
			}
		}
		String message=String.format(template,(name2.isEmpty())?"HEllo world":name2);
		greetingToEdit.setMessage(message);
		return greetingRepository.save(greetingToEdit);

	}
	

package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GREETINGS")
public class Greeting 
{
	@Id
	private long id;
	private String message;
	
	public Greeting()
	{
		id=0;
		message="";
	}
	
	public Greeting(long id, String message)
	{
		
		this.id = id;
		this.message = message;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", message=" + message + "]";
	}
	
	
	

}

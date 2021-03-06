package com.bridgelabz.greetingapp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;



@RestController
@RequestMapping("/greeting")
public class GreetingController 
{
    private static final String template="Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;
    
    // curl -X POST http://localhost:8080/greeting/add?name=Ted
    @PostMapping(value = {"","/","/add"})
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name)
    {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    //curl -X GET http://localhost:8080/greeting/greetingid/?id=2
    @GetMapping(value = {"/greetingid"})
    public Greeting getGreetingByID(@RequestParam(value="id",defaultValue="World") long id)
    {
        
        return greetingService.getGreetingById(id);
    }
    
    //curl -X GET http://localhost:8080/greeting/greetinglist
    @GetMapping("/greetinglist")
    public List<Greeting> getGreetingList()
    {
    	return greetingService.getGreetingList();
    }
    
    //curl -X PUT localhost:8080/greeting/update/Ted/Lisa -w "\n"
    @PutMapping("/update/{name1}/{name2}")
    public Greeting editGreeting(@PathVariable String name1, @PathVariable String name2)
	{
        
		return greetingService.editGreeting(name1, name2);
    }

    //curl -X DELETE localhost:8080/greeting/delete/Lisa -w "\n"
    @DeleteMapping("/delete/{name}")
    public List<Greeting> deleteGreeting(@PathVariable String name)
	{
        
		return greetingService.deleteGreeting(name);
    }
    

}

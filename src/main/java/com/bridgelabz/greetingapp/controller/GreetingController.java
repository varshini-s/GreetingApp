package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.greetingapp.model.Greeting;



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

    @GetMapping("/param/{name}")
    public Greeting sayHelloParam(@PathVariable String name)
    {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    
    @PostMapping("/post")
    public Greeting sayHello(@RequestBody Greeting greeting)
    {

        return new Greeting(greeting.getId(),greeting.getMessage());
    }
	
    @PutMapping("put/{name}")
    public Greeting sayHello(@PathVariable String name)
	{
        
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}

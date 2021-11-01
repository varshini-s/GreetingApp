package com.bridgelabz.greetingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.greetingapp.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}

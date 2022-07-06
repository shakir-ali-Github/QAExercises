package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Fish;

public interface FishRepo extends JpaRepository<Fish, Integer> {
	
	Fish findByNameStartingWithIgnoreCase(String name);

}

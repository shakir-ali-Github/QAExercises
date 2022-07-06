package com.example.demo.service;

import java.util.List;

import com.example.demo.Fish;

public interface FishService {
	
	Fish getById(int id);

	List<Fish> getAll();

	Fish findByName(String name);

	Fish create(Fish fish);

	Fish update(int id, String name, String species, Integer age);

	void delete(int id);

}

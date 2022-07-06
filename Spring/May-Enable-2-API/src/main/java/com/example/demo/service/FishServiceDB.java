package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Fish;
import com.example.demo.repo.FishRepo;

@Service
@Primary
public class FishServiceDB implements FishService {
	
	@Autowired
	private FishRepo repo;

	@Override
	public Fish getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Fish> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Fish create(Fish fish) {
		return this.repo.save(fish);
	}

	@Override
	public Fish update(int id, String name, String species, Integer age) {
		Fish toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (age != null)
			toUpdate.setAge(age);
		if (species != null)
			toUpdate.setSpecies(species);
		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Fish findByName(String name) {
		// TODO Auto-generated method stub
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}
	
	

}

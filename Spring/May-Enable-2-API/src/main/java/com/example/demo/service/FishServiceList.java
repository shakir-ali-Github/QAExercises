package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Fish;

@Service

public class FishServiceList implements FishService{
	
	private List<Fish> fishs = new ArrayList<>();

	@Override
	public Fish getById(int id) {
		return this.fishs.get(id);

	}

	@Override
	public List<Fish> getAll() {
		return this.fishs;
	}

	@Override
	public Fish create(Fish fish) {
		this.fishs.add(fish);
		return this.fishs.get(this.fishs.size() - 1);

	}

	@Override
	public Fish update(int id, String name, String species, Integer age) {
		Fish toUpdate = this.fishs.get(id);
		if (name != null)
			toUpdate.setName(name);
		if (age != null)
			toUpdate.setAge(age);
		if (species != null)
			toUpdate.setSpecies(species);
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.fishs.remove(id);
	}

	@Override
	public Fish findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}

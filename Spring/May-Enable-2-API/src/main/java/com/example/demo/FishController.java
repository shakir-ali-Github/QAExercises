package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController {
	
	private List<Fish> fishs = new ArrayList<>();

	@GetMapping("/hello")
	public String helloWorld() {
		String a = "Hello, ";
		String b = "World!";
		return a + b;
	}
	
	@GetMapping("/demoFish")
	public Fish getDemoFish() {
		return new Fish("Maas", "Tuna", Integer.MAX_VALUE);
	}

	@PostMapping("/createFish")
	public Fish create(@RequestBody Fish fish) {
		System.out.println("Created: " + fish);
		this.fishs.add(fish);
		return this.fishs.get(this.fishs.size() - 1);
	}
	
	@PatchMapping("/updateFish/{id}")
	public void update(@PathVariable("id") int id, @PathParam("name") String name, @PathParam("species") String species,
			@PathParam("age") int age) {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Species: " + species);
		System.out.println("Age: " + age);
	}

	// id = 4494
	@DeleteMapping("/removeFish/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
	}
	

}

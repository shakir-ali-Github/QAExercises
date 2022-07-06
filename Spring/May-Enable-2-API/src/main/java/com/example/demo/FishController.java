package com.example.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FishService;

@RestController
public class FishController {
	
	@Autowired
	private FishService service; // dependency

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

	@GetMapping("/getFish/{id}")
	public Fish getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/getFishs")
	public List<Fish> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getFishByName/{name}")
	public Fish getDinoByName(@PathVariable String name) {
		return this.service.findByName(name);
	}

	@PostMapping("/createFish")
	public ResponseEntity<Fish> create(@RequestBody Fish fish) {
		System.out.println("Created: " + fish);
		Fish created = this.service.create(fish);

		return new ResponseEntity<Fish>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateFish/{id}")
	public Fish update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("species") String species, @PathParam("age") Integer age) {
		return this.service.update(id, name, species, age);
	}

	// id = 4494
	@DeleteMapping("/removeFish/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

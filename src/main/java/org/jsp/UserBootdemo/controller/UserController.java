 package org.jsp.UserBootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.UserBootdemo.dto.ResponseStructure;
import org.jsp.UserBootdemo.dto.User;
import org.jsp.UserBootdemo.repository.UserRepository;
import org.jsp.UserBootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3001/")
public class UserController {
	@Autowired
 private UserService service;
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUser(@PathVariable int id) {
		return service.findUser(id);
	}
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		return service.findAll();
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	@PostMapping("/users/verify-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone,@RequestParam String password){
		return service.verifyUser(phone,password);
	}
	@GetMapping("/users/verify-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,@RequestParam String password){
		return service.verifyUser(email,password);
	}
}

//RestController
//public class UserController{
//	Autowired
//	private UserService service;
//	PostMapping("/users")
//	public User saveUser(@RequestBody User user) {
//	return service.saveUser(user);
//	}
//	@PutMapping("/users")
//	public User updateUser(@RequestBody User user) {
//		return service.updateUser(user);
//	}
//	@GetMapping("/users/{id}")
//	public User findUser(@RPathVariable int id) {
//		return service.findUser(id);
//	}
//	@GetMapping("/users")
//	public List<User> findAll(){
//		return service.findAll();
//	}
//	@DeleteMapping("/users/{id}")
//	public String deleteUser(@PathVariable int id) {
//		return service.deleteUser(id);
//	}
//}


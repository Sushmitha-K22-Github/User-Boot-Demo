package org.jsp.UserBootdemo.service;

import java.util.List;
import java.util.Optional;

import org.jsp.UserBootdemo.dao.UserDao;
import org.jsp.UserBootdemo.dto.ResponseStructure;
import org.jsp.UserBootdemo.dto.User;
import org.jsp.UserBootdemo.exception.IdNotFoundException;
import org.jsp.UserBootdemo.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
private UserDao dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user saved succefully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(	structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user updated succefully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		ResponseStructure<User> structure=new ResponseStructure<User>();
		Optional<User> recievedUser=dao.findUser(id);
		if( recievedUser.isPresent()) {
			structure.setBody(recievedUser.get());
		structure.setCode(HttpStatus.OK.value());
		structure.setMessage("user found");
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setBody(dao.findAll());
		structure.setMessage("All users are displayed");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		Optional<User>  recievedUser=dao.findUser(id);
		if( recievedUser.isPresent()) {
			dao.deleteUser(id);
			structure.setBody("user deleted");
		structure.setCode(HttpStatus.OK.value());
		structure.setMessage("user found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}
		structure.setBody("user not deleted");
		structure.setMessage("user not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> structure=new ResponseStructure<User>();
		Optional<User>  recievedUser=dao.verifyUser(phone,password);
		if( recievedUser.isPresent()) {
			structure.setBody(recievedUser.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("user verified succefully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		ResponseStructure<User> structure=new ResponseStructure<User>();
		Optional<User>  recievedUser=dao.verifyUser(email,password);
		if( recievedUser.isPresent()) {
			structure.setBody(recievedUser.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("user verified succefully");
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	}

//Service
//public class UserService{
//	Autowired
//	private UserDao dao;
//	public User saveUser(User user) {
//		return dao.saveUser(user);
//	}
//	public User updateUser(User user) {
//		return dao.updateUser(user);
//	}
//	public User findUser(int id) {
//		Optional<User> recieveUser=dao.findUser(id);
//		if(recieveUser.isPresent())
//			return recieveUser.get();
//		return null;
//	}
//	public List<User> findAll(){
//		return dao.findAll();
//	}
//	public String deleteUser(int id) {
//		Optional<User> recieveUser=dao.findUser(id);
//		if(recieveUser.isPresent())
//			dao.deleteUser(id);
//			return "user deleted";
//	}
//		return "can't delete user";
//	}
//}

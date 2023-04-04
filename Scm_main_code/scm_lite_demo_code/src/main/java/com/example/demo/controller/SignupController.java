package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;
import com.example.demo.service.SignupService;
import com.example.demo.service.UserService;

//import static com.example.demo.validation.SignupValidation.uservalidation;

import java.util.List;



@RestController
public class SignupController {
	
	@Autowired
	SignupRepository signupreopository;
	
	@Autowired
	private UserService userService;

//	@PostMapping(value ="/signup")
////	public String Createuser (@RequestBody Signup signup) throws Exception {
//		public String createuser(@RequestBody Signup signup){
//
//			return UserService.register(signup);
//
//		
////			return	uservalidation(signup.getUsername(),signup.getEmail(),signup.getPassword(),signupreopository,signupService);
//				  
//		}
	@PostMapping(value = "/signup")
	public String createuser(@RequestBody Signup signup){
//		if(signup.getPassword().equals(signup.getConfirmPassword())) {
			return userService.register(signup);
//		}
//		return "Password Not Matched";
	}
		
	
	


//	@PostMapping(value = "/login")
//	public ResponseEntity<Object> Loginuser (@RequestBody Signup signup) throws Exception {
//		if (!signupService.Authenticate(signup.getEmail(), signup.getPassword())) {
//
//			return ResponseEntity.internalServerError().header("Custom-Header", "failure").body("Failure Again you change something");
//
//		} else {
//			return ResponseEntity.ok().header("Custom-Header", "success").body("Success");
//
//		}		
//			
//	}
//	@GetMapping(value="/allusers")
//	public List<Signup> getAllEmployees() {
//
//		return signupService.getallUsers();
//	} 
	
	
}

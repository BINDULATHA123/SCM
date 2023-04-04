//package com.example.demo.validation;
//
//import java.util.regex.Pattern;
//import org.springframework.http.ResponseEntity;
//
//import com.example.demo.model.Signup;
//import com.example.demo.repository.SignupRepository;
//import com.example.demo.service.SignupService;
//public class SignupValidation {
//	
//	public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
//			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
//	public static final String special_char = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
//
//	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//
//	public static ResponseEntity<Object> uservalidation(String username,String email,String password,SignupRepository repo,
//			SignupService service){
//		
//		java.util.regex.Matcher matcher = pattern.matcher(email);
//		String upperCaseChars = "(.*[A-Z].*)";
//		String lowerCaseChars = "(.*[a-z].*)";
//		String numbers = "(.*[0-9].*)";
//		
//		if (username.length() == 0) {
//		
//			return ResponseEntity.internalServerError().header("Custom-Header","not empty").body("username not empty");
//		}
//		else if (username.length() >30) {
//		
//			return ResponseEntity.internalServerError().header("Custom-Header","not empty").body("username not exceed more than 30 characters ");
//		}
//		
//		else if (!matcher.matches()) {
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("email is not valid");
//			
//		} 
//		else if (password.length() < 8) {
//			
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("Password should be less than 15 and more than 8 characters in length.");
//		}
//		else if (!password.matches(upperCaseChars)) {
//			
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("Password should contain atleast one upper case alphabet");
//		}
//		else if (!password.matches(lowerCaseChars)) {
//		
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("Password should contain atleast one lower case alphabet");
//		}
//		else if (!password.matches(numbers)) {
//			
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("Password should contain atleast one number.");
//		}
//
//		else if (!password.matches(special_char)) {
//	
//			return ResponseEntity.internalServerError().header("Custom-Header", "not empty").body("Password should contain atleast one special character");
//		}
//		else if (repo.existsByEmail(email)) {
//			return ResponseEntity.internalServerError().header("Custom-Header", "already exist").body("User already exits");
//
//		}
//
//		else {
//			Signup signup= new Signup(username,email,password);
//			PasswordEncryptionValidation.encryption(signup);
//			 service.SigupUsers(signup);
//
//			return ResponseEntity.ok().header("Custom-Header", "success").body("Success case");
//		
//		}
//		
//	
//
//	}
//
//	
//
//
//
//}

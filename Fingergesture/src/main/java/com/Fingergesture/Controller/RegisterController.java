package com.Fingergesture.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Model.RegisterDTO;
import com.Fingergesture.Service.RegisterService;



@RestController
@RequestMapping("/Register")
public class RegisterController {
	
	
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private Environment environment;
	

	@PostMapping("/addNewUser")
	public ResponseEntity<String> addNewUser(@RequestBody RegisterDTO registerDTO) throws Exception{
		ResponseEntity<String> response=null;
		try {
	         registerService.addNewUser(registerDTO);
		
			response=new ResponseEntity<String>(HttpStatus.CREATED);
			
		
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String message=environment.getProperty(e.getMessage());
				response=new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
				
			}
			else {
				throw e;
				
			}
				
		}
		return response;
	}
	
	


	
	

	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam ("emailId") String emailId) throws Exception{
		ResponseEntity<String> response=null;
		try {
	        registerService.deleteUser(emailId);
			String message=environment.getProperty("UserInterface.DELETE_SUCCESS");
			response=new ResponseEntity<String>(message,HttpStatus.CREATED);
			
		
		}catch (Exception e) {
			if(e.getMessage()!=null) {
				String message=environment.getProperty(e.getMessage());
				response=new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
				
			}
			else {
				throw e;
			}
				
		}
		return response;
	}
	
	
	@PutMapping("/updateUserImage")
	public ResponseEntity<String> addNewImage(@RequestParam("emailId") String emailId,@RequestBody MultipartFile file) throws Exception{
		ResponseEntity<String> response=null;
		try {
			registerService.updateImage(emailId, file);
			
			response=new ResponseEntity<String>(HttpStatus.OK);
		}catch (Exception e) {
			 throw e;
		}
		return response;
		
	}
	
	

	@GetMapping("/getImage")
	
	public ResponseEntity<?> getImage(@RequestParam("emailId") String filename) throws Exception{
		ResponseEntity<?> response=null;
		try {
			byte[] images=registerService.getimage(filename);
			
			response=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		}catch (Exception e) {
			 throw e;
		}
		return response;
		
	}

}

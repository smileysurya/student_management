package com.Fingergesture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Fingergesture.Model.Module_3DTO;
import com.Fingergesture.Service.Module_3Service;







@RestController
@RequestMapping("/Module_3")
public class Module_3Controller {
	
	@Autowired
	private Module_3Service module_3Service;
	
	
	@PostMapping("/addModule_3Info")
	  public ResponseEntity<String> addModule_3Info(@RequestBody Module_3DTO module_3dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
			  module_3Service.addNewModule_3Info(module_3dto);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
	
		@GetMapping("/getModule_3InfoById")
		  public ResponseEntity<Module_3DTO> getModule_3Info(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<Module_3DTO> response=null;
			  
			  try {
				  Module_3DTO info= module_3Service.getSModule_3InfoById(id);
				   response= new  ResponseEntity<Module_3DTO>(info,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteModule_3Info")
	  public ResponseEntity<String> deleteModule_3Info(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     module_3Service.deleteModule_3Info(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateModule_3Info")
	  public ResponseEntity<String> updateModule_3Info(@RequestParam("id") Integer id,@RequestBody Module_3DTO module_3dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
			  module_3Service.updateModule_3Info(id, module_3dto);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllModule_3Info")
	  public ResponseEntity<List<Module_3DTO>>getModule_3InfoList()throws Exception{
			ResponseEntity<List<Module_3DTO>>response=null;
		  
		  try {
			  List<Module_3DTO> std=module_3Service.getAllModule_3Info();
			   response= new ResponseEntity<List<Module_3DTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   


}

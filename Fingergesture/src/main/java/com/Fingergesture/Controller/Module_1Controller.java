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

import com.Fingergesture.Model.Module_1DTO;
import com.Fingergesture.Service.Module_1Service;



@RestController
@RequestMapping("/Module_1")
public class Module_1Controller {
	
	@Autowired
	private Module_1Service module_1Service;
	
	
	@PostMapping("/addModule_1Info")
	  public ResponseEntity<String> addaddModule_1Info(@RequestBody Module_1DTO module_1dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
			  module_1Service.addNewModule_1Info(module_1dto);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
	
		@GetMapping("/getModule_1InfoById")
		  public ResponseEntity<Module_1DTO> getModule_1Info(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<Module_1DTO> response=null;
			  
			  try {
				  Module_1DTO info= module_1Service.getSModule_1InfoById(id);
				   response= new  ResponseEntity<Module_1DTO>(info,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteModule_1Info")
	  public ResponseEntity<String> deleteModule_1Info(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     module_1Service.deleteModule_1Info(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateModule_1Info")
	  public ResponseEntity<String> updateModule_1Info(@RequestParam("id") Integer id,@RequestBody Module_1DTO module_1dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
			  module_1Service.updateModule_1Info(id, module_1dto);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllModule_1Info")
	  public ResponseEntity<List<Module_1DTO>>getModule_1InfoList()throws Exception{
			ResponseEntity<List<Module_1DTO>>response=null;
		  
		  try {
			  List<Module_1DTO> std=module_1Service.getAllModule_1Info();
			   response= new ResponseEntity<List<Module_1DTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   


}

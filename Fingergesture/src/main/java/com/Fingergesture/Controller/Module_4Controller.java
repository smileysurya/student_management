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

import com.Fingergesture.Model.Module_4DTO;
import com.Fingergesture.Service.Module_4Service;







@RestController
@RequestMapping("/Module_4")
public class Module_4Controller {
	
	@Autowired
	private Module_4Service module_4Service;
	
	
	@PostMapping("/addModule_4Info")
	  public ResponseEntity<String> addModule_4Info(@RequestBody Module_4DTO module_4dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
			  module_4Service.addNewModule_4Info(module_4dto);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
	
		@GetMapping("/getModule_4InfoById")
		  public ResponseEntity<Module_4DTO> getModule_4Info(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<Module_4DTO> response=null;
			  
			  try {
				  Module_4DTO info= module_4Service.getSModule_4InfoById(id);
				   response= new  ResponseEntity<Module_4DTO>(info,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteModule_4Info")
	  public ResponseEntity<String> deleteModule_4Info(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     module_4Service.deleteModule_4Info(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateModule_4Info")
	  public ResponseEntity<String> updateModule_4Info(@RequestParam("id") Integer id,@RequestBody Module_4DTO module_4dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
			  module_4Service.updateModule_4Info(id, module_4dto);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllModule_4Info")
	  public ResponseEntity<List<Module_4DTO>>getModule_4InfoList()throws Exception{
			ResponseEntity<List<Module_4DTO>>response=null;
		  
		  try {
			  List<Module_4DTO> std=module_4Service.getAllModule_4Info();
			   response= new ResponseEntity<List<Module_4DTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   


}

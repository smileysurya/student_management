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

import com.Fingergesture.Model.Module_5DTO;
import com.Fingergesture.Service.Module_5Service;









@RestController
@RequestMapping("/Module_5")
public class Module_5Controller {
	
	@Autowired
	private Module_5Service module_5Service;
	
	
	@PostMapping("/addModule_5Info")
	  public ResponseEntity<String> addModule_4Info(@RequestBody Module_5DTO module_5dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
			  module_5Service.addNewModule_5Info(module_5dto);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
	
		@GetMapping("/getModule_5InfoById")
		  public ResponseEntity<Module_5DTO> getModule_5Info(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<Module_5DTO> response=null;
			  
			  try {
				  Module_5DTO info= module_5Service.getSModule_5InfoById(id);
				   response= new  ResponseEntity<Module_5DTO>(info,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteModule_5Info")
	  public ResponseEntity<String> deleteModule_5Info(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     module_5Service.deleteModule_5Info(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateModule_5Info")
	  public ResponseEntity<String> updateModule_5Info(@RequestParam("id") Integer id,@RequestBody Module_5DTO module_5dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
			  module_5Service.updateModule_5Info(id, module_5dto);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllModule_5Info")
	  public ResponseEntity<List<Module_5DTO>>getModule_4InfoList()throws Exception{
			ResponseEntity<List<Module_5DTO>>response=null;
		  
		  try {
			  List<Module_5DTO> std=module_5Service.getAllModule_5Info();
			   response= new ResponseEntity<List<Module_5DTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   


}

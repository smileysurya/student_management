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

import com.Fingergesture.Model.Module_2DTO;
import com.Fingergesture.Service.Module_2Service;





@RestController
@RequestMapping("/Module_2")
public class Module_2Controller {
	
	@Autowired
	private Module_2Service module_2Service;
	
	
	@PostMapping("/addModule_2Info")
	  public ResponseEntity<String> addModule_2Info(@RequestBody Module_2DTO module_2dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
			  module_2Service.addNewModule_2Info(module_2dto);
		 
		  response=new   ResponseEntity<String>(HttpStatus.CREATED);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return response;
		  
		  
		  
	  }
	  
	
		@GetMapping("/getModule_2InfoById")
		  public ResponseEntity<Module_2DTO> getModule_2InfoById(@RequestParam("id") Integer id)throws Exception{
				ResponseEntity<Module_2DTO> response=null;
			  
			  try {
				  Module_2DTO info= module_2Service.getSModule_2InfoById(id);
				   response= new  ResponseEntity<Module_2DTO>(info,HttpStatus.OK);
			  }catch (Exception e) {
				throw e;
			}

			return response;
			  
		  }
		
	  @DeleteMapping("/deleteModule_2Info")
	  public ResponseEntity<String> deleteModule_2Info(@RequestParam("id") Integer id) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		     module_2Service.deleteModule_2Info(id);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  
	  @PutMapping("/updateModule_2Info")
	  public ResponseEntity<String> updateModule_2Info(@RequestParam("id") Integer id,@RequestBody Module_2DTO module_2dto) throws Exception{
		  ResponseEntity<String> response=null;
		  try {
		 
		 
			  module_2Service.updateModule_2Info(id, module_2dto);
		  response=new   ResponseEntity<String>(HttpStatus.OK);
		  }catch (Exception e) {
			if(e.getMessage()!=null) {
			
			response=new   ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
			}
		}
		return response;
	  }
	  @GetMapping("/getAllModule_2Info")
	  public ResponseEntity<List<Module_2DTO>>getModule_2InfoList()throws Exception{
			ResponseEntity<List<Module_2DTO>>response=null;
		  
		  try {
			  List<Module_2DTO> std=module_2Service.getAllModule_2Info();
			   response= new ResponseEntity<List<Module_2DTO>> (std,HttpStatus.OK);
		  }catch (Exception e) {
		 throw e;
		}

		return response;
		  
	}
	   


}

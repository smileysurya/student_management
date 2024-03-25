package com.Fingergesture.Service;

import java.util.List;

import com.Fingergesture.Model.Module_3DTO;





public interface Module_3Service {

	
	
	public void addNewModule_3Info(Module_3DTO module_3DTO) throws Exception;
	public Module_3DTO getSModule_3InfoById(Integer id) throws Exception;
	public void updateModule_3Info(Integer id, Module_3DTO module_3DTO) throws Exception;
	public void deleteModule_3Info(Integer id) throws Exception;
	public List<Module_3DTO> getAllModule_3Info() throws Exception;
	
}

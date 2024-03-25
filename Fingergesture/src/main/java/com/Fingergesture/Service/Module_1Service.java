package com.Fingergesture.Service;

import java.util.List;

import com.Fingergesture.Model.Module_1DTO;






public interface Module_1Service {

	
	
	public void addNewModule_1Info(Module_1DTO module_1DTO) throws Exception;
	public Module_1DTO getSModule_1InfoById(Integer id) throws Exception;
	public void updateModule_1Info(Integer id, Module_1DTO module_1DTO) throws Exception;
	public void deleteModule_1Info(Integer id) throws Exception;
	public List<Module_1DTO> getAllModule_1Info() throws Exception;
	
}

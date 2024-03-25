package com.Fingergesture.Service;

import java.util.List;

import com.Fingergesture.Model.Module_5DTO;







public interface Module_5Service {

	
	
	public void addNewModule_5Info(Module_5DTO module_5DTO) throws Exception;
	public Module_5DTO getSModule_5InfoById(Integer id) throws Exception;
	public void updateModule_5Info(Integer id, Module_5DTO module_5DTO) throws Exception;
	public void deleteModule_5Info(Integer id) throws Exception;
	public List<Module_5DTO> getAllModule_5Info() throws Exception;
	
}

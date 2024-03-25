package com.Fingergesture.Service;

import java.util.List;

import com.Fingergesture.Model.Module_4DTO;







public interface Module_4Service {

	
	
	public void addNewModule_4Info(Module_4DTO module_4DTO) throws Exception;
	public Module_4DTO getSModule_4InfoById(Integer id) throws Exception;
	public void updateModule_4Info(Integer id, Module_4DTO module_4DTO) throws Exception;
	public void deleteModule_4Info(Integer id) throws Exception;
	public List<Module_4DTO> getAllModule_4Info() throws Exception;
	
}

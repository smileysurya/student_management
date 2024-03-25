package com.Fingergesture.Service;

import java.util.List;

import com.Fingergesture.Model.Module_2DTO;





public interface Module_2Service {

	
	
	public void addNewModule_2Info(Module_2DTO module_2DTO) throws Exception;
	public Module_2DTO getSModule_2InfoById(Integer id) throws Exception;
	public void updateModule_2Info(Integer id, Module_2DTO module_2DTO) throws Exception;
	public void deleteModule_2Info(Integer id) throws Exception;
	public List<Module_2DTO> getAllModule_2Info() throws Exception;
	
}

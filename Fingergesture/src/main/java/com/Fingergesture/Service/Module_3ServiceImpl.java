package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Module_3;
import com.Fingergesture.Model.Module_3DTO;
import com.Fingergesture.Repository.Module_3Repository;




@Service
public class Module_3ServiceImpl implements Module_3Service {
	
	@Autowired
	private Module_3Repository module_3Repository;

	@Override
	public void addNewModule_3Info(Module_3DTO module_3dto) throws Exception {
		
		Module_3 module_3=new Module_3();
		module_3.setInstance1(module_3dto.getInstance1());
		module_3.setInstance2(module_3dto.getInstance2());
		module_3.setInstance3(module_3dto.getInstance3());
		module_3.setInstance4(module_3dto.getInstance4());
		module_3.setInstance5(module_3dto.getInstance5());
		module_3Repository.save(module_3);
		
		
	}

	@Override
	public Module_3DTO getSModule_3InfoById(Integer id) throws Exception {
	Optional<Module_3> optional=module_3Repository.findById(id);
	 Module_3 module_3=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
	 Module_3DTO module_3dto=new Module_3DTO();
	 module_3dto.setId(module_3.getId());
	 module_3dto.setInstance1(module_3.getInstance1());
	 module_3dto.setInstance2(module_3.getInstance2());
	 module_3dto.setInstance3(module_3.getInstance3());
	 module_3dto.setInstance4(module_3.getInstance4());
	 module_3dto.setInstance5(module_3.getInstance5());
		return module_3dto;
	}

	@Override
	public void updateModule_3Info(Integer id, Module_3DTO module_3dto) throws Exception {
		Optional<Module_3> optional=module_3Repository.findById(id);
		 Module_3 module_3=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
			module_3.setInstance1(module_3dto.getInstance1());
			module_3.setInstance2(module_3dto.getInstance2());
			module_3.setInstance3(module_3dto.getInstance3());
			module_3.setInstance4(module_3dto.getInstance4());
			module_3.setInstance5(module_3dto.getInstance5());
			module_3Repository.save(module_3);
		
	}

	@Override
	public void deleteModule_3Info(Integer id) throws Exception {
		Optional<Module_3> optional=module_3Repository.findById(id);
		 Module_3 module_3=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
		 module_3Repository.deleteById(id);
	}

	@Override
	public List<Module_3DTO> getAllModule_3Info() throws Exception {
		List<Module_3DTO> module_3dtos=new ArrayList<>();
		Iterable<Module_3> moduleFromRepo=module_3Repository.findAll();
		for(Module_3 module_3:moduleFromRepo) {
			 Module_3DTO module_3dto=new Module_3DTO();
			 module_3dto.setId(module_3.getId());
			 module_3dto.setInstance1(module_3.getInstance1());
			 module_3dto.setInstance2(module_3.getInstance2());
			 module_3dto.setInstance3(module_3.getInstance3());
			 module_3dto.setInstance4(module_3.getInstance4());
			 module_3dto.setInstance5(module_3.getInstance5());
			 module_3dtos.add(module_3dto);
		}
		return module_3dtos;
	}

}

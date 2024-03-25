package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Module_1;
import com.Fingergesture.Model.Module_1DTO;
import com.Fingergesture.Repository.Module_1Repository;


@Service
public class Module_1ServiceImpl implements Module_1Service {
	
	@Autowired
	private Module_1Repository module_1Repository;

	@Override
	public void addNewModule_1Info(Module_1DTO module_1dto) throws Exception {
		
		Module_1 module_1=new Module_1();
		module_1.setInstance1(module_1dto.getInstance1());
		module_1.setInstance2(module_1dto.getInstance2());
		module_1.setInstance3(module_1dto.getInstance3());
		module_1.setInstance4(module_1dto.getInstance4());
		module_1.setInstance5(module_1dto.getInstance5());
		module_1Repository.save(module_1);
		
		
	}

	@Override
	public Module_1DTO getSModule_1InfoById(Integer id) throws Exception {
	Optional<Module_1> optional=module_1Repository.findById(id);
	 Module_1 module_1=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
	 Module_1DTO module_1dto=new Module_1DTO();
	 module_1dto.setId(module_1.getId());
	 module_1dto.setInstance1(module_1.getInstance1());
	 module_1dto.setInstance2(module_1.getInstance2());
	 module_1dto.setInstance3(module_1.getInstance3());
	 module_1dto.setInstance4(module_1.getInstance4());
	 module_1dto.setInstance5(module_1.getInstance5());
		return module_1dto;
	}

	@Override
	public void updateModule_1Info(Integer id, Module_1DTO module_1dto) throws Exception {
		Optional<Module_1> optional=module_1Repository.findById(id);
		 Module_1 module_1=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
			module_1.setInstance1(module_1dto.getInstance1());
			module_1.setInstance2(module_1dto.getInstance2());
			module_1.setInstance3(module_1dto.getInstance3());
			module_1.setInstance4(module_1dto.getInstance4());
			module_1.setInstance5(module_1dto.getInstance5());
			module_1Repository.save(module_1);
		
	}

	@Override
	public void deleteModule_1Info(Integer id) throws Exception {
		Optional<Module_1> optional=module_1Repository.findById(id);
		 Module_1 module_1=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
		 module_1Repository.deleteById(id);
	}

	@Override
	public List<Module_1DTO> getAllModule_1Info() throws Exception {
		List<Module_1DTO> module_1dtos=new ArrayList<>();
		Iterable<Module_1> moduleFromRepo=module_1Repository.findAll();
		for(Module_1 module_1:moduleFromRepo) {
			 Module_1DTO module_1dto=new Module_1DTO();
			 module_1dto.setId(module_1.getId());
			 module_1dto.setInstance1(module_1.getInstance1());
			 module_1dto.setInstance2(module_1.getInstance2());
			 module_1dto.setInstance3(module_1.getInstance3());
			 module_1dto.setInstance4(module_1.getInstance4());
			 module_1dto.setInstance5(module_1.getInstance5());
			 module_1dtos.add(module_1dto);
		}
		return module_1dtos;
	}

}

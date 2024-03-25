package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Module_5;
import com.Fingergesture.Model.Module_5DTO;
import com.Fingergesture.Repository.Module_5Repository;






@Service
public class Module_5ServiceImpl implements Module_5Service {
	
	@Autowired
	private Module_5Repository module_5Repository;

	@Override
	public void addNewModule_5Info(Module_5DTO module_5dto) throws Exception {
		
		Module_5 module_5=new Module_5();
		module_5.setInstance1(module_5dto.getInstance1());
		module_5.setInstance2(module_5dto.getInstance2());
		module_5.setInstance3(module_5dto.getInstance3());
		module_5.setInstance4(module_5dto.getInstance4());
		module_5.setInstance5(module_5dto.getInstance5());
		module_5Repository.save(module_5);
		
		
	}

	@Override
	public Module_5DTO getSModule_5InfoById(Integer id) throws Exception {
	Optional<Module_5> optional=module_5Repository.findById(id);
	 Module_5 module_5=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
	 Module_5DTO module_5dto=new Module_5DTO();
	 module_5dto.setId(module_5.getId());
	 module_5dto.setInstance1(module_5.getInstance1());
	 module_5dto.setInstance2(module_5.getInstance2());
	 module_5dto.setInstance3(module_5.getInstance3());
	 module_5dto.setInstance4(module_5.getInstance4());
	 module_5dto.setInstance5(module_5.getInstance5());
		return module_5dto;
	}

	@Override
	public void updateModule_5Info(Integer id, Module_5DTO module_5dto) throws Exception {
		Optional<Module_5> optional=module_5Repository.findById(id);
		 Module_5 module_5=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
			module_5.setInstance1(module_5dto.getInstance1());
			module_5.setInstance2(module_5dto.getInstance2());
			module_5.setInstance3(module_5dto.getInstance3());
			module_5.setInstance4(module_5dto.getInstance4());
			module_5.setInstance5(module_5dto.getInstance5());
			module_5Repository.save(module_5);
		
	}

	@Override
	public void deleteModule_5Info(Integer id) throws Exception {
		Optional<Module_5> optional=module_5Repository.findById(id);
		 Module_5 module_5=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
		 module_5Repository.deleteById(id);
	}

	@Override
	public List<Module_5DTO> getAllModule_5Info() throws Exception {
		List<Module_5DTO> module_5dtos=new ArrayList<>();
		Iterable<Module_5> moduleFromRepo=module_5Repository.findAll();
		for(Module_5 module_5:moduleFromRepo) {
			 Module_5DTO module_5dto=new Module_5DTO();
			 module_5dto.setId(module_5.getId());
			 module_5dto.setInstance1(module_5.getInstance1());
			 module_5dto.setInstance2(module_5.getInstance2());
			 module_5dto.setInstance3(module_5.getInstance3());
			 module_5dto.setInstance4(module_5.getInstance4());
			 module_5dto.setInstance5(module_5.getInstance5());
			 module_5dtos.add(module_5dto);
		}
		return module_5dtos;
	}

}

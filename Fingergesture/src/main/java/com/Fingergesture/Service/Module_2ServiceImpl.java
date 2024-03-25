package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Module_2;
import com.Fingergesture.Model.Module_2DTO;
import com.Fingergesture.Repository.Module_2Repository;




@Service
public class Module_2ServiceImpl implements Module_2Service {
	
	@Autowired
	private Module_2Repository module_2Repository;

	@Override
	public void addNewModule_2Info(Module_2DTO module_2dto) throws Exception {
		
		Module_2 module_2=new Module_2();
		module_2.setInstance1(module_2dto.getInstance1());
		module_2.setInstance2(module_2dto.getInstance2());
		module_2.setInstance3(module_2dto.getInstance3());
		module_2.setInstance4(module_2dto.getInstance4());
		module_2.setInstance5(module_2dto.getInstance5());
		module_2Repository.save(module_2);
		
		
	}

	@Override
	public Module_2DTO getSModule_2InfoById(Integer id) throws Exception {
	Optional<Module_2> optional=module_2Repository.findById(id);
	 Module_2 module_2=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
	 Module_2DTO module_2dto=new Module_2DTO();
	 module_2dto.setId(module_2.getId());
	 module_2dto.setInstance1(module_2.getInstance1());
	 module_2dto.setInstance2(module_2.getInstance2());
	 module_2dto.setInstance3(module_2.getInstance3());
	 module_2dto.setInstance4(module_2.getInstance4());
	 module_2dto.setInstance5(module_2.getInstance5());
		return module_2dto;
	}

	@Override
	public void updateModule_2Info(Integer id, Module_2DTO module_2dto) throws Exception {
		Optional<Module_2> optional=module_2Repository.findById(id);
		 Module_2 module_2=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
			module_2.setInstance1(module_2dto.getInstance1());
			module_2.setInstance2(module_2dto.getInstance2());
			module_2.setInstance3(module_2dto.getInstance3());
			module_2.setInstance4(module_2dto.getInstance4());
			module_2.setInstance5(module_2dto.getInstance5());
			module_2Repository.save(module_2);
		
	}

	@Override
	public void deleteModule_2Info(Integer id) throws Exception {
		Optional<Module_2> optional=module_2Repository.findById(id);
		 Module_2 module_1=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
		 module_2Repository.deleteById(id);
	}

	@Override
	public List<Module_2DTO> getAllModule_2Info() throws Exception {
		List<Module_2DTO> module_2dtos=new ArrayList<>();
		Iterable<Module_2> moduleFromRepo=module_2Repository.findAll();
		for(Module_2 module_2:moduleFromRepo) {
			 Module_2DTO module_2dto=new Module_2DTO();
			 module_2dto.setId(module_2.getId());
			 module_2dto.setInstance1(module_2.getInstance1());
			 module_2dto.setInstance2(module_2.getInstance2());
			 module_2dto.setInstance3(module_2.getInstance3());
			 module_2dto.setInstance4(module_2.getInstance4());
			 module_2dto.setInstance5(module_2.getInstance5());
			 module_2dtos.add(module_2dto);
		}
		return module_2dtos;
	}

}

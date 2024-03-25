package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Module_4;
import com.Fingergesture.Model.Module_4DTO;
import com.Fingergesture.Repository.Module_4Repository;






@Service
public class Module_4ServiceImpl implements Module_4Service {
	
	@Autowired
	private Module_4Repository module_4Repository;

	@Override
	public void addNewModule_4Info(Module_4DTO module_4dto) throws Exception {
		
		Module_4 module_4=new Module_4();
		module_4.setInstance1(module_4dto.getInstance1());
		module_4.setInstance2(module_4dto.getInstance2());
		module_4.setInstance3(module_4dto.getInstance3());
		module_4.setInstance4(module_4dto.getInstance4());
		module_4.setInstance5(module_4dto.getInstance5());
		module_4Repository.save(module_4);
		
		
	}

	@Override
	public Module_4DTO getSModule_4InfoById(Integer id) throws Exception {
	Optional<Module_4> optional=module_4Repository.findById(id);
	 Module_4 module_4=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
	 Module_4DTO module_4dto=new Module_4DTO();
	 module_4dto.setId(module_4.getId());
	 module_4dto.setInstance1(module_4.getInstance1());
	 module_4dto.setInstance2(module_4.getInstance2());
	 module_4dto.setInstance3(module_4.getInstance3());
	 module_4dto.setInstance4(module_4.getInstance4());
	 module_4dto.setInstance5(module_4.getInstance5());
		return module_4dto;
	}

	@Override
	public void updateModule_4Info(Integer id, Module_4DTO module_4dto) throws Exception {
		Optional<Module_4> optional=module_4Repository.findById(id);
		 Module_4 module_4=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
			module_4.setInstance1(module_4dto.getInstance1());
			module_4.setInstance2(module_4dto.getInstance2());
			module_4.setInstance3(module_4dto.getInstance3());
			module_4.setInstance4(module_4dto.getInstance4());
			module_4.setInstance5(module_4dto.getInstance5());
			module_4Repository.save(module_4);
		
	}

	@Override
	public void deleteModule_4Info(Integer id) throws Exception {
		Optional<Module_4> optional=module_4Repository.findById(id);
		 Module_4 module_4=optional.orElseThrow(()->  new Exception("Service.Not_Found"));
		 module_4Repository.deleteById(id);
	}

	@Override
	public List<Module_4DTO> getAllModule_4Info() throws Exception {
		List<Module_4DTO> module_4dtos=new ArrayList<>();
		Iterable<Module_4> moduleFromRepo=module_4Repository.findAll();
		for(Module_4 module_4:moduleFromRepo) {
			 Module_4DTO module_4dto=new Module_4DTO();
			 module_4dto.setId(module_4.getId());
			 module_4dto.setInstance1(module_4.getInstance1());
			 module_4dto.setInstance2(module_4.getInstance2());
			 module_4dto.setInstance3(module_4.getInstance3());
			 module_4dto.setInstance4(module_4.getInstance4());
			 module_4dto.setInstance5(module_4.getInstance5());
			 module_4dtos.add(module_4dto);
		}
		return module_4dtos;
	}

}

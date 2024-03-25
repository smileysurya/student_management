package com.Fingergesture.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Entity.Component_1;
import com.Fingergesture.Model.Component_1DTO;
import com.Fingergesture.Repository.Component_1Repository;
import com.Fingergesture.Validation.Validation;






@Service
public class Component_1ServiceImpl implements Component_1Service {
	
	@Autowired
	private Component_1Repository component_1Repository;
	
	@Autowired
	private Validation validation;

	public void addNewComponent1(String cmpDef, MultipartFile image1, MultipartFile image2, MultipartFile image3)
			throws Exception {
		if(validation.countWords(cmpDef)) {
			throw new Exception("Service.Max_Limit_reached_Def");
			
		}
		else if (image1.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_1");
		}
		else if (image2.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_2");
		}
		else if (image3.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_3");
		}
		Component_1 component_1=new Component_1();
		
		component_1.setComponentDef(cmpDef);
		component_1.setComponentImage1(image1.getBytes());
		component_1.setComponentImage2(image2.getBytes());
		component_1.setComponentImage3(image3.getBytes());
		component_1Repository.save(component_1);
	}

	@Override
	public Component_1DTO getComponent1() throws Exception {
		Optional<Component_1> optional=component_1Repository.findFirstByOrderByIdDesc();
		Component_1 component_1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		Component_1DTO component1dto=new Component_1DTO();
		component1dto.setComponentDef(component_1.getComponentDef());
		return component1dto;
	}

	@Override
	public byte[] getComponentImg1() throws Exception {
		Optional<Component_1> optional=component_1Repository.findFirstByOrderByIdDesc();
		Component_1 component_1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_1.getComponentImage1();
	}

	@Override
	public byte[] getComponentImg2() throws Exception {
		Optional<Component_1> optional=component_1Repository.findFirstByOrderByIdDesc();
		Component_1 component_1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_1.getComponentImage2();
	}

	@Override
	public byte[] getComponentImg3() throws Exception {
		Optional<Component_1> optional=component_1Repository.findFirstByOrderByIdDesc();
		Component_1 component_1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_1.getComponentImage3();
	}

	@Override
	public void updateComponent(String cmpDef, MultipartFile image1, MultipartFile image2, MultipartFile image3)
			throws Exception {
		if(validation.countWords(cmpDef)) {
			throw new Exception("Service.Max_Limit_reached_Def");
			
		}
		else if (image1.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_1");
		}
		else if (image2.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_2");
		}
		else if (image3.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img_3");
		}
		Component_1 component_1=new Component_1();
		component_1.setComponentDef(cmpDef);
		component_1.setComponentImage1(image1.getBytes());
		component_1.setComponentImage2(image2.getBytes());
		component_1.setComponentImage3(image3.getBytes());
		component_1Repository.save(component_1);
		
	}

}

package com.Fingergesture.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Entity.Component_2;
import com.Fingergesture.Model.Component_2DTO;
import com.Fingergesture.Repository.Component_2Repository;
import com.Fingergesture.Validation.Validation;



@Service
public class Component_2ServiceImpl implements Component_2Service {
	
	@Autowired
	private Component_2Repository component_2Repository;
	@Autowired
	private Validation validation;
	
	
	public void addNewComponent(String cmpDef, MultipartFile image1, MultipartFile image2, MultipartFile image3)
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
		Component_2 component_2=new Component_2();
		component_2.setComponentDef(cmpDef);
		component_2.setComponentImage1(image1.getBytes());
		component_2.setComponentImage2(image2.getBytes());
		component_2.setComponentImage3(image3.getBytes());
		component_2Repository.save(component_2);
	}

	
	public Component_2DTO getComponent() throws Exception {
		Optional<Component_2> optional=component_2Repository.findFirstByOrderByIdDesc();
		Component_2 component_2=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		Component_2DTO component1dto=new Component_2DTO();
		component1dto.setComponentDef(component_2.getComponentDef());
		return component1dto;
	}


	public byte[] getComponentImg1() throws Exception {
		Optional<Component_2> optional=component_2Repository.findFirstByOrderByIdDesc();
		Component_2 component_2=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_2.getComponentImage1();
	}

	
	public byte[] getComponentImg2() throws Exception {
		Optional<Component_2> optional=component_2Repository.findFirstByOrderByIdDesc();
		Component_2 component_2=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_2.getComponentImage2();
	}

	
	public byte[] getComponentImg3() throws Exception {
		Optional<Component_2> optional=component_2Repository.findFirstByOrderByIdDesc();
		Component_2 component_2=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		return component_2.getComponentImage3();
	}

	
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
		Component_2 component_2=new Component_2();
		component_2.setComponentDef(cmpDef);
		component_2.setComponentImage1(image1.getBytes());
		component_2.setComponentImage2(image2.getBytes());
		component_2.setComponentImage3(image3.getBytes());
		component_2Repository.save(component_2);
		
	}


}

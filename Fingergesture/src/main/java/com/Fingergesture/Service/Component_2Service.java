package com.Fingergesture.Service;

import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Model.Component_2DTO;




public interface Component_2Service {
	
	public void addNewComponent(String cmpDef,MultipartFile image1,MultipartFile image2,MultipartFile image3) throws Exception;
	public Component_2DTO getComponent() throws Exception;
	public  byte[]getComponentImg1() throws Exception;
	public  byte[]getComponentImg2() throws Exception;
	public  byte[]getComponentImg3() throws Exception;
	public void updateComponent(String cmpDef,MultipartFile image1,MultipartFile image2,MultipartFile image3) throws Exception;


}

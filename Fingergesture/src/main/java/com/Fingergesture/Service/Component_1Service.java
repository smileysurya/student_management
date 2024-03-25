package com.Fingergesture.Service;




import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Model.Component_1DTO;



public interface Component_1Service{
	
	public void addNewComponent1(String cmpDef,MultipartFile image1,MultipartFile image2,MultipartFile image3) throws Exception;
	public Component_1DTO getComponent1() throws Exception;
	public  byte[]getComponentImg1() throws Exception;
	public  byte[]getComponentImg2() throws Exception;
	public  byte[]getComponentImg3() throws Exception;
	public void updateComponent(String cmpDef,MultipartFile image1,MultipartFile image2,MultipartFile image3) throws Exception;

}

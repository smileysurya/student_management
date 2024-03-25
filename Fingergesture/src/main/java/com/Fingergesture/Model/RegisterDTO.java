package com.Fingergesture.Model;




import com.Fingergesture.Entity.Register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
	
	private Integer registerId;
    private String emailId;
    private String password;
    private String confirmPassword;
	private byte[] image;
	
 public  static Register createRegisterEntity(RegisterDTO registerDTO) throws Exception{
	 
	 Register register=new Register();
	 register.setEmailId(registerDTO.getEmailId());
	 register.setPassword(registerDTO.getPassword());
	 return register;
	 
 }
}

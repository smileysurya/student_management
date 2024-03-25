package com.Fingergesture.Service;

import com.Fingergesture.Model.LoginDTO;

public interface LoginService {
	
	
	public String validateUser(LoginDTO loginDTO) throws Exception; 
	public LoginDTO getUser(String emailId)throws Exception;
	public void updateUser(String emailId,LoginDTO loginDTO )throws Exception;

}

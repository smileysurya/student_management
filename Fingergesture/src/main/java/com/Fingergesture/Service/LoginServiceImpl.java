package com.Fingergesture.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fingergesture.Entity.Register;
import com.Fingergesture.Model.LoginDTO;
import com.Fingergesture.Repository.RegisterRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public String validateUser(LoginDTO loginDTO) throws Exception {
		Optional<Register> optional=registerRepository.findByEmailId(loginDTO.getEmailId());
		if(optional.isEmpty()) {
			throw new Exception("Service.Not_Found");
		}else {
			if(loginDTO.getPassword().equals(optional.get().getPassword())) {
				return " User Logged Sucessfully";
			}else {
				return "invalidUser";
			}
		}
		
	}

	@Override
	public LoginDTO getUser(String emailId) throws Exception {
		Optional<Register> optional=registerRepository.findByEmailId(emailId);
		Register register= optional.orElseThrow(()->new Exception("Service.Not_Found"));
		
		LoginDTO loginDTO=new LoginDTO();
		loginDTO.setEmailId(register.getEmailId());
		loginDTO.setPassword(register.getPassword());
		
		
		return loginDTO;
		
	}
	
	
	@Override
	public void updateUser(String emailId, LoginDTO loginDTO) throws Exception {
		Optional<Register> optional = registerRepository.findByEmailId(emailId);
		Register register = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		register.setEmailId(loginDTO.getEmailId());
		register.setPassword(loginDTO.getPassword());
		registerRepository.save(register);

	}

	
	
	
	
}

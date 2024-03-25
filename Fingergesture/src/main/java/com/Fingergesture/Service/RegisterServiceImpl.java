package com.Fingergesture.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Entity.Register;
import com.Fingergesture.Model.RegisterDTO;
import com.Fingergesture.Repository.RegisterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public void addNewUser(RegisterDTO registerDTO) throws Exception {
		Optional<Register> optional = registerRepository.findByEmailId(registerDTO.getEmailId());
		if (optional.isPresent()) {
			throw new Exception("Service.Duplicate_Found");
		}

		else if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
			throw new Exception("Service.Invalid_Confirm_Password");
		}

		else {
			registerRepository.save(RegisterDTO.createRegisterEntity(registerDTO));
		}

	}

	@Override
	public void deleteUser(String emailId) throws Exception {
		Optional<Register> optional = registerRepository.findByEmailId(emailId);
		if(optional.isEmpty()) {
			throw new Exception("Service.Not_Found");
		}
		registerRepository.deleteByEmailId(emailId);

	}

	@Override
	public void updateUser(String emailId, RegisterDTO registerDTO) throws Exception {
		Optional<Register> optional = registerRepository.findByEmailId(emailId);
		Register register = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		register.setEmailId(registerDTO.getEmailId());
		register.setPassword(registerDTO.getPassword());
		registerRepository.save(register);

	}

	@Override
	public void updateImage(String emailId, MultipartFile image) throws Exception {
		Optional<Register> optional = registerRepository.findByEmailId(emailId);
		Register register = optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		
		register.setImage(image.getBytes());
		registerRepository.save(register);
	}
	@Override
	public byte[] getimage(String filename) throws Exception {
		Optional<Register> optional=registerRepository.findByEmailId(filename);
		if(optional.isEmpty()) {
			throw new Exception("Service.Not_Found");
		}
		
	
		return optional.get().getImage();
	}

	
	

}

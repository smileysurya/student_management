package com.Fingergesture.Entity;



import com.Fingergesture.Model.RegisterDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer registerId;
    private String emailId;
    private String password;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] image;
  
    
    public  static RegisterDTO createRegisterDto(Register register) throws Exception{
   	 
    	RegisterDTO registerDto=new RegisterDTO();
    	registerDto.setEmailId(register.getEmailId());
    	registerDto.setPassword(register.getPassword());
   	 return registerDto;
   	 
    }

}

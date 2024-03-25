package com.Fingergesture.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Module_2 {
	
	@Id
	@SequenceGenerator(name="mod2_gen",sequenceName = "mod2_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "mod2_gen",strategy = GenerationType.AUTO)
	private Integer id;
	private String instance1;
	private String instance2;
	private String instance3;
	private String instance4;
	private String instance5;
}

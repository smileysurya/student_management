package com.Fingergesture.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Abstract {
	
	@Id
	@SequenceGenerator(name="abs_gen",sequenceName = "abs_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "abs_gen",strategy = GenerationType.AUTO)
	private Integer id;
	  @Column(columnDefinition = "text")
	private String abstractDef;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] abstractImage;

}

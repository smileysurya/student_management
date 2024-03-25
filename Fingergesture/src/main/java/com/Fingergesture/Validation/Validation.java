package com.Fingergesture.Validation;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
 public boolean	countWords(String absDef) throws Exception{

	int maxWords=300;
	
	 String[] words = absDef.split("\\s+");
	 if(words.length>=maxWords) {
		return true;
	 }
	return false;
	
	
	}

}

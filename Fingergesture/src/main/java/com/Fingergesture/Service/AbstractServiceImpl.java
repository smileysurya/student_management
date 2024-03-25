package com.Fingergesture.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Entity.Abstract;
import com.Fingergesture.Model.AbstractDTO;
import com.Fingergesture.Repository.AbstractRepository;
import com.Fingergesture.Validation.Validation;




@Service
public class AbstractServiceImpl implements AbstractService {

	@Autowired
	private AbstractRepository abstractRepository;
	
	@Autowired
	private Validation validation;

	@Override
	public void addNewAbstract(String absDef,MultipartFile file) throws Exception {

		
		if(validation.countWords(absDef)) {
			throw new Exception("Service.Max_Limit_reached_Def");
			
		}
		else if (file.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img");
		}
		Abstract abstract1 = new Abstract();
		
		abstract1.setAbstractDef(absDef);
		abstract1.setAbstractImage(file.getBytes());
		System.out.println(file.getBytes().length);

		abstractRepository.save(abstract1);
	}

	@Override
	public List<AbstractDTO> getAbstract() throws Exception {
		List<AbstractDTO> abstractDTOs = new ArrayList<>();
		Iterable<Abstract> abstractFromRepo = abstractRepository.findAll();
		for (Abstract abstractList : abstractFromRepo) {
           AbstractDTO abstractDTO=new AbstractDTO();
           abstractDTO.setAbstractDef(abstractList.getAbstractDef());
           abstractDTO.setAbstractImage(abstractList.getAbstractImage());
			abstractDTOs.add(abstractDTO);
		}

		return abstractDTOs;
	}
	
	public AbstractDTO  getAbstractDef() throws Exception{
		
	Optional<Abstract> optional=abstractRepository.findFirstByOrderByIdDesc();
	   Abstract abstract1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		AbstractDTO abstractDTO=new AbstractDTO();
		
		abstractDTO.setAbstractDef(abstract1.getAbstractDef());
		
		return abstractDTO;
		
		
	}
	
	public void updateAbstract(String absDef,MultipartFile file) throws Exception{
		
		Optional<Abstract> optional=abstractRepository.findFirstByOrderByIdDesc();
		Abstract abstract1=optional.orElseThrow(() -> new Exception("Service.Not_Found"));
		if(validation.countWords(absDef)) {
			throw new Exception("Service.Max_Limit_reached_Def");
			
		}
		else if (file.getSize()>1*1024*1024) {
			throw new Exception("Service.Max_Limit_reached_Img");
		}
		abstract1.setAbstractDef(absDef);
		abstract1.setAbstractImage(file.getBytes());
		abstractRepository.save(abstract1);
	}




	public byte[] getAbstractImg() throws Exception {
		Optional<Abstract> optional=abstractRepository.findFirstByOrderByIdDesc();
		if(optional.isEmpty()) {
			throw new Exception("Service.Not_Found");
		}
		
	
		return optional.get().getAbstractImage();

	}

}

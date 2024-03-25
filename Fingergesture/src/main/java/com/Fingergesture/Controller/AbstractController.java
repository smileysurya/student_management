package com.Fingergesture.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Fingergesture.Model.AbstractDTO;
import com.Fingergesture.Service.AbstractService;





@RestController
@RequestMapping("/abstract")
public class AbstractController {

	@Autowired
	private AbstractService abstractService;



	@PostMapping("/addAbstract")
	public ResponseEntity<String> addNewAbstract(@RequestParam("absDef") String absDef,
			@RequestParam("file") MultipartFile file) throws Exception {
		ResponseEntity<String> response = null;
		try {

			abstractService.addNewAbstract(absDef, file);

			response = new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			if (e.getMessage() != null) {

				response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

			} else {
				throw e;

			}

		}
		return response;
	}

	@GetMapping("/getAbstract")
	public ResponseEntity<AbstractDTO> getAbstract() throws Exception {
		ResponseEntity<AbstractDTO> response = null;
		try {
			AbstractDTO list = abstractService.getAbstractDef();
			response = new ResponseEntity<AbstractDTO>(list, HttpStatus.OK);

		} catch (Exception e) {
			throw e;

		}
		return response;

	}
     @GetMapping("/getAbstractImage")
	
	public ResponseEntity<?> getImage() throws Exception{
		ResponseEntity<?> response=null;
		try {
			byte[] images=abstractService.getAbstractImg();
			
			response=ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		}catch (Exception e) {
			 throw e;
		}
		return response;
		
	}

	@PutMapping("/updateAbstract")
	public ResponseEntity<String> updateAbstract(@RequestParam("absDef") String absDef,
			@RequestParam("file") MultipartFile file) throws Exception {
		ResponseEntity<String> response = null;
		try {

			abstractService.updateAbstract(absDef, file);

			response = new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			if (e.getMessage() != null) {

				response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

			} else {
				throw e;

			}

		}
		return response;
	}

}





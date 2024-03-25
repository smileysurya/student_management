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

import com.Fingergesture.Model.Component_2DTO;
import com.Fingergesture.Service.Component_2Service;




@RestController
@RequestMapping("/component_2")
public class Component_2Controller {
	
	

	@Autowired
	private Component_2Service component_2Service;

	@PostMapping("/addComponent_2")
	public ResponseEntity<String> addNewComponent2(@RequestParam("cmpDef") String absDef,
			@RequestParam("file1") MultipartFile image1, @RequestParam("file2") MultipartFile image2,
			@RequestParam("file3") MultipartFile image3) throws Exception {
		ResponseEntity<String> response = null;
		try {

			 component_2Service.addNewComponent(absDef, image1, image2, image3);

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

	@GetMapping("/getcomponent_2")
	public ResponseEntity<?> getComponent1() throws Exception {
		ResponseEntity<?> response = null;
		try {
			Component_2DTO list = component_2Service.getComponent();
			response = new ResponseEntity<Component_2DTO>(list, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@GetMapping("/getcomponent_2Image1")

	public ResponseEntity<?> getImage1() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_2Service.getComponentImg1();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@GetMapping("/getcomponent_2Image2")

	public ResponseEntity<?> getImage2() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_2Service.getComponentImg2();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@GetMapping("/getcomponent_2Image3")

	public ResponseEntity<?> getImage3() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_2Service.getComponentImg3();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@PutMapping("/updateComponent_2")
	public ResponseEntity<String> updateComponent1(@RequestParam("cmpDef") String cmpDef,
			@RequestParam("file1") MultipartFile image1, @RequestParam("file2") MultipartFile image2,
			@RequestParam("file3") MultipartFile image3) throws Exception {
		ResponseEntity<String> response = null;
		try {

			component_2Service.updateComponent(cmpDef, image1, image2, image3);

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

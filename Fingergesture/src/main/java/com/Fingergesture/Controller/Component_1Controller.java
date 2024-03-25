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

import com.Fingergesture.Model.Component_1DTO;
import com.Fingergesture.Service.Component_1Service;



@RestController
@RequestMapping("/component_1")
public class Component_1Controller {

	@Autowired
	private Component_1Service component_1Service;

	@PostMapping("/addComponent_1")
	public ResponseEntity<String> addNewComponent1(@RequestParam("cmpDef") String absDef,
			@RequestParam("file1") MultipartFile image1, @RequestParam("file2") MultipartFile image2,
			@RequestParam("file3") MultipartFile image3) throws Exception {
		ResponseEntity<String> response = null;
		try {

			component_1Service.addNewComponent1(absDef, image1, image2, image3);

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

	@GetMapping("/getcomponent_1")
	public ResponseEntity<Component_1DTO> getComponent1() throws Exception {
		ResponseEntity<Component_1DTO> response = null;
		try {
			Component_1DTO list = component_1Service.getComponent1();
			response = new ResponseEntity<Component_1DTO>(list, HttpStatus.OK);

		} catch (Exception e) {
			throw e;

		}
		return response;

	}

	@GetMapping("/getcomponent_1Image1")

	public ResponseEntity<?> getImage1() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_1Service.getComponentImg1();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@GetMapping("/getcomponent_1Image2")

	public ResponseEntity<?> getImage2() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_1Service.getComponentImg2();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@GetMapping("/getcomponent_1Image3")

	public ResponseEntity<?> getImage3() throws Exception {
		ResponseEntity<?> response = null;
		try {
			byte[] images = component_1Service.getComponentImg3();

			response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(images);
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@PutMapping("/updateComponent_1")
	public ResponseEntity<String> updateComponent1(@RequestParam("cmpDef") String cmpDef,
			@RequestParam("file1") MultipartFile image1, @RequestParam("file2") MultipartFile image2,
			@RequestParam("file3") MultipartFile image3) throws Exception {
		ResponseEntity<String> response = null;
		try {

			component_1Service.updateComponent(cmpDef, image1, image2, image3);

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

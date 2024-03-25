package com.Fingergesture.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Fingergesture.Model.LoginDTO;
import com.Fingergesture.Service.LoginService;


@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private LoginService  loginService;

	@Autowired
	private Environment environment;

	@PostMapping("/ValidateUser")
	public ResponseEntity<String> addNewUser(@RequestBody LoginDTO loginDTO) throws Exception {
		ResponseEntity<String> response = null;
		try {
			String validateUser = loginService.validateUser(loginDTO);
			response = new ResponseEntity<String>(validateUser, HttpStatus.OK);

		} catch (Exception e) {
			if (e.getMessage() != null) {
				String message = environment.getProperty(e.getMessage());
				response = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

			} else {
				throw e;

			}

		}
		return response;
	}

	@GetMapping("/getUser")
	public ResponseEntity<LoginDTO> getUser(@RequestParam("emailId") String emailId) throws Exception {
		ResponseEntity<LoginDTO> response = null;
		try {
			LoginDTO loginDTO = loginService.getUser(emailId);
			response = new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestParam("emailId") String emailId, @RequestBody LoginDTO loginDTO)
			throws Exception {
		ResponseEntity<String> response = null;
		try {
			loginService.updateUser(emailId, loginDTO);
			String message = environment.getProperty("UserInterface.UPDATE_SUCCESS");
			response = new ResponseEntity<String>(message, HttpStatus.OK);

		} catch (Exception e) {
			if (e.getMessage() != null) {
				String message = environment.getProperty(e.getMessage());
				response = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);

			} else {
				throw e;
			}

		}
		return response;
	}

}

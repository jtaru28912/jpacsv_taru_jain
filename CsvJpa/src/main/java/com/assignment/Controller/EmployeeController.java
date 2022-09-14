package com.assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.service.EmpService;

import io.swagger.annotations.ApiParam;

@RestController
public class EmployeeController {
	// DI
	@Autowired
	private EmpService sr;

	// CALLING THE POST METHOD TO SAVE THE RECORDS IN THE EMPLOYEE TABLE USINMG
	// SWAGGER
	@RequestMapping(value = "/csv/add", method = RequestMethod.POST)
	public ResponseEntity<String> saveEmp(@RequestPart("file") @ApiParam(value="File", required=true) MultipartFile file
			,Model model){
		sr.saveEmployeeData(file, model);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}

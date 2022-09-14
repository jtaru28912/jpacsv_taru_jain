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

import com.assignment.service.FileService;

import io.swagger.annotations.ApiParam;

@RestController
public class FileController {
	// DI
	@Autowired
	FileService fs;

	// CALLING POST METHOD VIA SWAGGER
	@RequestMapping(value = "/file/add", method = RequestMethod.POST)
	public ResponseEntity<String> setFileDataInDb(@RequestPart("file") @ApiParam(value="File", required=true)
	MultipartFile file,Model model) {
		
			// save the data ..
			fs.saveFileData(file, model);
			return new ResponseEntity<String>("FILE INFORMATION IS SAVED SUCCESSFULLY!!", HttpStatus.OK);
		
	}

}

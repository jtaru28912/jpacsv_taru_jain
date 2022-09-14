package com.assignment.service;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.entity.FileEntity;
import com.assignment.repo.FileRepo;
import com.assignment.serviceinterface.FileServiceInterface;

@Service
public class FileService implements FileServiceInterface {
	// DI
	@Autowired
	private FileRepo fr;

	// get number of lines/records
	public String numberOfRecords(MultipartFile file, Model model) {

		// initially the value of line is 0
		long lines = 0;

		// for taking the input BuffreReader is used
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			while (reader.readLine() != null)
				lines++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		// excluding headings as a record count
		// parsing the value into String
		String s = String.valueOf(lines - 1);
		return s;
	}

	// creating the object of Date class
	Date date = new Date();

	// this will check for duplicates
	public boolean checkduplicate() {
//		FileEntity file= new FileEntity ();
//		FileEntity existingFile = fr.findByFileName(file.getfName());
//		if (existingFile == null) {
//			return true;
//		} else if (file.getfName() == existingFile.getfName() && file.getNoOfRecords() == existingFile.getNoOfRecords())
//
//		{
//			System.out.println("File already Exist");
//			return false;
//		}
//		return true;

		// set is a datastructure used to store the values/records
		Set<String> duplicateFile = new HashSet<>();
		List<FileEntity> filename = new ArrayList<>();
		for (FileEntity fe : filename) {
			duplicateFile.add(fe.getfName());
		}
		if (duplicateFile.size() != 1) {
			return true;
		} else {
			return false;
		}
	}

	public String saveFileData(MultipartFile file, Model model) {

		// creating object of our entity class
		FileEntity fe = new FileEntity();

		// filename
		fe.setfName(file.getOriginalFilename());

		// creation date
		// using SimpleDateformat to represent in dfate format
		fe.setCreateDate(new SimpleDateFormat("E yyyy.MM.dd").format(date));

		// num of records
		fe.setNoOfRecords(numberOfRecords(file, model));

		// update
		// using SimpleDateformat to represent in dfate format
		fe.setUpdatedDate(new SimpleDateFormat("E yyyy.MM.dd").format(date));

		fr.save(fe);
		return "Record Saved Successfully";

	}

}

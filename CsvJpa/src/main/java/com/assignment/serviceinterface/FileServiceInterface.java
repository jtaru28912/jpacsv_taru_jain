package com.assignment.serviceinterface;

import org.springframework.ui.Model;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInterface {

	public String numberOfRecords(MultipartFile file, Model model);
	public boolean checkduplicate();
	public String saveFileData(MultipartFile file, Model model);
}

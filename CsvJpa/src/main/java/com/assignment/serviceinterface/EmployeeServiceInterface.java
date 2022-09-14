package com.assignment.serviceinterface;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeServiceInterface {
	public void saveEmployeeData(MultipartFile file,Model model);
}

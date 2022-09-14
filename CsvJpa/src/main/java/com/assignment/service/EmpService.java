package com.assignment.service;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.entity.Employee;
import com.assignment.repo.EmployeeRepo;
import com.assignment.serviceinterface.EmployeeServiceInterface;

@Service
public class EmpService implements EmployeeServiceInterface {
	// DI
	@Autowired
	private EmployeeRepo repo;
	//List<Integer> IdOfEmployee = new ArrayList<>();

	// function for dynamic input of data
	public void saveEmployeeData(MultipartFile file, Model model) {

		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {
			try {
				BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
				int rowN = 0;
				String line = "";

				while ((line = bf.readLine()) != null) {
					// logic for skipping the 1st row as it will be the heading
					if (rowN == 0) {
						rowN++;
						continue;
					}
					String[] data = line.split(",");
					Employee e = new Employee();
					e.setFirstName(data[0]);
					e.setMiddleName(data[1]);
					e.setLastName(data[2]);
					e.setAge(data[3]);
					e.setSalary(data[4]);
					e.setEmailId(data[5]);
					//check duplicate entry
					List<Employee> exist = repo.findByFirstName(data[0]);
					if ((exist.size() == 0)) {
						repo.save(e);
						System.out.println("Successfully saved!");

					} else {
						System.out.println("Unable to insert record !\n Duplicate Entry");
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}

package com.example.backend;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(BackendApplication.class, args);
		//prescription generation for test purpose
		//TODO move it to prescription controller
		String filepath = "/home/dsi/DSIProjects/prescription-system-dsi/backend/src/main/resources/templates/prescription.jrxml";
		Map<String, Object> params = new HashMap<>();
		params.put("doctorName", "Dr. John Doe");
		params.put("clinicPhoneNumber", "123-456-7890");
		params.put("clinicAddress", "123 Main St, City, Country");
		params.put("clinicName", "ABC Clinic");
		params.put("doctorPhoneNo", "987-654-3210");
		params.put("doctorSpeciality", "Cardiologist");
		params.put("patientGender", "Male");
		params.put("patientAddress", "456 Elm St, City, Country");
		params.put("patientAge", 35);
		params.put("patientId", 123456789L);
		params.put("patientName", "John Smith");
		params.put("patientHeight", 175.5);
		params.put("patientWeight", 70.2);
		params.put("patientBp", "120/80");
		params.put("createdAt", "2022-05-01");

		JasperReport report = JasperCompileManager.compileReport(filepath);
		JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "/home/dsi/DSIProjects/prescription-system-dsi/backend/src/main/resources/static/prescription.pdf");
		System.out.println("Report has been saved successfully");






	}

}

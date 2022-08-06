package com.beesan.PatientService;



import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Patient;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PatientRepository {
	private static final Map<String, Patient> patients = new HashMap<>();

	@PostConstruct
	public void initData() {
		Patient d = new Patient();
		d .setName("beesan");
		d.setAge(20);
		d.setDob("aguest");
		d.setGender("female");
		
		patients.put(d.getName(),d);

	}

	public Patient findPatient(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return patients.get(name);
		
	}
}

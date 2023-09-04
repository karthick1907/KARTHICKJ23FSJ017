package edu.disease.asn2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImplTest {
	private DiseaseControlManager dCManager;

	@BeforeEach
	public void init() {
		// not working
//		dCManager = new DiseaseControlManagerImpl(10, 10);
	}

	@Test
	public void addDiseaseTest() {
		dCManager = new DiseaseControlManagerImpl(10, 10);
		assertNotNull(dCManager);

		Disease d = dCManager.addDisease("Covid", true);
		Disease d2 = dCManager.getDisease(d.getDiseaseId());
		assertEquals(d, d2);

	}

	@Test
	public void getDiseaseTest() {

		dCManager = new DiseaseControlManagerImpl(10, 10);

		Disease d = dCManager.addDisease("Covid", true);
		Disease d2 = dCManager.getDisease(d.getDiseaseId());
		assertEquals(d, d2);
	}
	
	@Test
	public void addPatientAndGetPatientTest() {
		
		dCManager = new DiseaseControlManagerImpl(10, 10);
		
		String firstName="Kat"; String lastName="Fat"; 
		int maxDisease=10; int maxExposure=10;
		
		
		Patient addPatient = dCManager.addPatient(firstName, lastName, maxDisease, maxExposure);
		
		Patient patient = dCManager.getPatient(addPatient.getPatientId());
		
		
		assertEquals(addPatient.getPatientId(), patient.getPatientId());
		
	}
	
	@Test
	public void addDiseaseToPatientTest() {
		dCManager = new DiseaseControlManagerImpl(10, 10);

		//add Patient
	
		String firstName="Kat"; String lastName="Fat"; 
		int maxDisease=10; int maxExposure=10;
				
		Patient addPatient = dCManager.addPatient(firstName, lastName, maxDisease, maxExposure);
				
	
		Patient patient = dCManager.getPatient(addPatient.getPatientId());
		
		
		//create add diease
		Disease d = dCManager.addDisease("Covid", true);

		Disease disease = dCManager.getDisease(d.getDiseaseId());
		
		dCManager.addDiseaseToPatient(patient.getPatientId(), disease.getDiseaseId());
		
		 boolean bool = dCManager.getPatient(patient.getPatientId()).containDiseaseId(disease.getDiseaseId());
		
		
		assertEquals(true, bool);
	}
	
	@Test
	public void addExposureToPatientTest() {
		
		dCManager = new DiseaseControlManagerImpl(10, 10);

		//add Patient
	
		String firstName="Kat"; String lastName="Fat"; 
		int maxDisease=10; int maxExposure=10;
				
		Patient addPatient = dCManager.addPatient(firstName, lastName, maxDisease, maxExposure);
				
		//create exposure
		Exposure e=new Exposure();
		e.setDateTime(LocalDateTime.now());
		e.setExposureType("I");
		e.setPatientId(addPatient.getPatientId());
		

		
		Patient patient = dCManager.getPatient(addPatient.getPatientId());

		dCManager.addExposureToPatient(patient.getPatientId(), e);
		
		Exposure[] exposures = patient.getExposures();
		
		int len = exposures.length;
		assertNotEquals(1, len);
	}
	

}

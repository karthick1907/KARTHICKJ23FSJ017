package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import edu.disease.asn1.Exposure;

public class PatientTest {
	
	private Patient patient;

	@BeforeEach
	void setUp() {
		patient = new Patient(4, 3);
		patient.setPatientId(UUID.randomUUID());
		patient.setFirstName("Kat");
		patient.setLastName("Sarn");
	}
	
	@Test
	public void testPatientConstructor() {
		int maxDiseases = 3;
		int maxExposures = 2;

		Patient patientObj = new Patient(maxDiseases, maxExposures);

		assertEquals(maxDiseases, patientObj.getDiseaseIds().length);
		assertEquals(maxExposures, patientObj.getExposures().length);
	}
	@Test
	public void testGetMethods() {
		Patient patient = new Patient(3, 2); 
		patient.setFirstName("John");
		patient.setLastName("Katia");
		assertEquals("Katia", patient.getLastName());
		assertEquals("John", patient.getFirstName());
		
	}
	@Test
	public void testAddDiseaseId() {
		int maxDiseases = 5;
		int maxExposures = 5;

		Patient patient = new Patient(maxDiseases, maxExposures);

		UUID dieaseId1 = UUID.randomUUID();
		UUID dieaseId2 = UUID.randomUUID();
		UUID dieaseId3 = UUID.randomUUID();

		patient.addDiseaseId(dieaseId1);
		patient.addDiseaseId(dieaseId2);
		patient.addDiseaseId(dieaseId3);

		UUID[] diseaseIds = patient.getDiseaseIds();

		assertEquals(dieaseId1, diseaseIds[0]);
		assertEquals(dieaseId2, diseaseIds[1]);
		assertEquals(dieaseId3, diseaseIds[2]);
	}
	@Test
	public void testAddExposure() {

		LocalDateTime datetime1 = LocalDateTime.now();
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = "D";
		Exposure e1 = new Exposure();
		e1.setDateTime(datetime1);
		e1.setExposureType(exposureType1);
		e1.setPatientId(patientId1);

		LocalDateTime datetime2 = LocalDateTime.now();
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = "D";
		Exposure e2 = new Exposure();
		e2.setDateTime(datetime2);
		e2.setExposureType(exposureType2);
		e2.setPatientId(patientId2);
		

		LocalDateTime datetime3 = LocalDateTime.now();
		UUID patientId3 = UUID.randomUUID();
		String exposureType3 = "D";
		Exposure e3 = new Exposure();
		e3.setDateTime(datetime3);
		e3.setExposureType(exposureType3);
		e3.setPatientId(patientId3);
		
		int maxDiseases = 3;
		int maxExposures = 3;
		
		Patient patient = new Patient(maxDiseases, maxExposures);
		
		patient.addExposure(e1);
		patient.addExposure(e2);
		patient.addExposure(e3);

		Exposure[] exposures = patient.getExposures();

		assertEquals(e1, exposures[0]);
		assertEquals(e2, exposures[1]);
		assertEquals(e3, exposures[2]);
	}
	
	@Test
	public void testEqualsAndHash() {
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		Patient patient1 = new Patient(3, 2);
		patient1.setPatientId(patientId1);

		Patient patient13 = new Patient(3, 2);
		patient13.setPatientId(patientId1);

		Patient patient2 = new Patient(4, 6);
		patient2.setPatientId(patientId2);

		assertTrue(patient1.equals(patient1));
		assertTrue(patient1.equals(patient13));
		assertTrue(patient1.equals(patient1));
		assertFalse(patient1.equals(patient2));

		assertEquals(patient1.hashCode(), patient13.hashCode());

	}
	
	
}

//package edu.disease.asn2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import edu.disease.asn1.Exposure;
//import edu.disease.asn1.constants.ExposureConstants;
//
//public class DiseaseControlManagerImplTestt {
//
//	private DiseaseControlManager manager;
//
//	@BeforeEach
//	public void setUp() {
//
//	}
//
//	@Test
//	public void testValidInitialization() {
//		manager = new DiseaseControlManagerImpl(10, 20);
//		assertNotNull(manager);
//	}
//
//	@Test
//	public void testZeroMaxDiseasesAndPatients() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			manager = new DiseaseControlManagerImpl(0, 0);
//		});
//	}
//
//	@Test
//	public void testNegativeMaxDiseasesAndPatients() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			manager = new DiseaseControlManagerImpl(-5, -10);
//		});
//	}
//
//	@Test
//	public void testZeroMaxDiseases() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			manager = new DiseaseControlManagerImpl(0, 5);
//		});
//	}
//
//	@Test
//	public void testZeroMaxPatients() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			manager = new DiseaseControlManagerImpl(6, 0);
//		});
//	}
//
//	@Test
//	public void testAddInfectiousDisease() {
//		manager = new DiseaseControlManagerImpl(5, 5); // Change array sizes as needed
//		Disease disease = manager.addDisease("COVID-19", true);
//		assertTrue(disease instanceof InfectiousDisease);
//		assertEquals("COVID-19", disease.getName());
//		assertNotNull(disease.getDiseaseId());
//	}
//
//	@Test
//	public void testAddNonInfectiousDisease() {
//		manager = new DiseaseControlManagerImpl(5, 5); // Change array sizes as needed
//		Disease disease = manager.addDisease("Diabetes", false);
//		assertTrue(disease instanceof NonInfectiousDisease);
//		assertEquals("Diabetes", disease.getName());
//		assertNotNull(disease.getDiseaseId());
//	}
//
//	@Test
//	public void testDiseaseArrayFull() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		manager.addDisease("Malaria", true);
//		manager.addDisease("Malaria", true);
//		assertThrows(IllegalStateException.class, () -> manager.addDisease("Malaria", true));
//	}
//
//	@Test
//	public void testGetDisease() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		Disease disease1 = manager.addDisease("Malaria", true);
//		Disease retrivedDisease = manager.getDisease(disease1.getDiseaseId());
//
//		assertNotNull(retrivedDisease);
//		assertEquals(disease1.getDiseaseId(), retrivedDisease.getDiseaseId());
//		assertEquals("Malaria", retrivedDisease.getName());
//	}
//
//	@Test
//	void testAddPatientSuccessfully() {
//		manager = new DiseaseControlManagerImpl(3, 3);
//		String firstName = "Sam";
//		String lastName = "Doe";
//		int maxDiseases = 5;
//		int maxExposures = 10;
//
//		Patient addedPatient = manager.addPatient(firstName, lastName, maxDiseases, maxExposures);
//
//		assertNotNull(addedPatient);
//		assertEquals(firstName, addedPatient.getFirstName());
//		assertEquals(lastName, addedPatient.getLastName());
//	}
//
//	@Test
//	public void testPatientArrayIsFull() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		String firstName = "Sam";
//		String lastName = "Doe";
//		int maxDiseases = 5;
//		int maxExposures = 10;
//
//		manager.addPatient(firstName, lastName, maxDiseases, maxExposures);
//		manager.addPatient(firstName, lastName, maxDiseases, maxExposures);
//
//		assertThrows(IllegalStateException.class,
//				() -> manager.addPatient(firstName, lastName, maxDiseases, maxExposures));
//	}
//
//	@Test
//	public void testGetPatient() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		String firstName = "Sam";
//		String lastName = "Doe";
//		int maxDiseases = 5;
//		int maxExposures = 10;
//
//		Patient patient = manager.addPatient(firstName, lastName, maxDiseases, maxExposures);
//		Patient retrivedPatient = manager.getPatient(patient.getPatientId());
//
//		assertNotNull(patient);
//		assertEquals(patient.getPatientId(), retrivedPatient.getPatientId());
//		assertEquals(firstName, retrivedPatient.getFirstName());
//		assertEquals(lastName, retrivedPatient.getLastName());
//	}
//
//	@Test
//	public void testAddDiseaseToPatient() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		Disease disease = manager.addDisease("Malaria", true);
//		Patient patient = manager.addPatient("Sam", "Joe", 2, 2);
//
//		UUID retrievedDiseaseId = disease.getDiseaseId();
//		UUID retrievedPatientId = patient.getPatientId();
//
//		manager.addDiseaseToPatient(retrievedPatientId, retrievedDiseaseId);
//
//		Patient retrievedPatient = manager.getPatient(retrievedPatientId);
//		assertNotNull(retrievedPatient);
//
//		Disease retrievedDisease = manager.getDisease(retrievedDiseaseId);
//		assertNotNull(retrievedDisease);
//
//		// Verify that the disease is added to the patient's disease list
//		assertTrue(arrayContainsDiseaseId(retrievedPatient.getDiseaseIds(), retrievedDiseaseId));
//	}
//
//	private boolean arrayContainsDiseaseId(UUID[] array, UUID targetId) {
//
//		for (UUID id : array) {
//			System.out.println("id" + id);
//			System.out.println("targetId" + targetId);
//			if (id != null) {
//				if (id.equals(targetId)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//
//	@Test
//	public void testAddExposureToPatient() {
//		manager = new DiseaseControlManagerImpl(2, 2);
//		Patient patient = manager.addPatient("Sam", "Joe", 2, 2);
//
//		LocalDateTime datetime = LocalDateTime.now();
//		UUID patientId = patient.getPatientId();
//		String exposureType = ExposureConstants.DIRECT_EXPOSURE;
//		Exposure exposureObj = new Exposure(datetime, patientId, exposureType);
//
//		patient.addExposure(exposureObj);
//
//		assertTrue(arrayContainsExposures(patient.getExposures(), exposureObj.getPatientId()));
//
//	}
//
//	private boolean arrayContainsExposures(Exposure[] exposures, UUID patientId) {
//		for (Exposure expose : exposures) {
//			if (expose != null) {
//				if (expose.getPatientId().equals(patientId)) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//}
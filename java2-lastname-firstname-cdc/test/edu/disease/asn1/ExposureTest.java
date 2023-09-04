package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

public class ExposureTest {

	@Test
	public void testExposureGetAndSetters() {

		LocalDateTime datetime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = "D";
		Exposure e = new Exposure();
		e.setDateTime(datetime);
		e.setPatientId(patientId);
		e.setExposureType(exposureType);

		assertEquals(datetime, e.getDateTime());
		assertEquals(patientId, e.getPatientId());
		assertEquals(exposureType, e.getExposureType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExposureTypeInValid() {
		LocalDateTime datetime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = "Disease";
		Exposure e = new Exposure();
		e.setDateTime(datetime);
		e.setPatientId(patientId);
		e.setExposureType(exposureType);

	}

	@Test
	public void testEqualsAndHashMethod() {
		LocalDateTime datetime1 = LocalDateTime.now();
		UUID patientId1 = UUID.randomUUID();
		String exposureType1 = "D";
		Exposure e = new Exposure();
		e.setDateTime(datetime1);
		e.setPatientId(patientId1);
		e.setExposureType(exposureType1);

		LocalDateTime datetime2 = LocalDateTime.now();
		UUID patientId2 = UUID.randomUUID();
		String exposureType2 = "D";
		Exposure e2 = new Exposure();
		e2.setDateTime(datetime2);
		e2.setPatientId(patientId2);
		e2.setExposureType(exposureType2);

		assertTrue(e.equals(e));
		assertFalse(e.equals(e2));
		assertNotEquals(e.hashCode(), e2.hashCode());
	}

	@Test
	public void testToString() {
		LocalDateTime dateTime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		String exposureType = "D";
		Exposure e = new Exposure();
		e.setDateTime(dateTime);
		e.setPatientId(patientId);
		e.setExposureType(exposureType);

		String expected = "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType="
				+ exposureType + "]";

		assertEquals(expected, e.toString());
	}

}

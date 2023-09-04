package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.*;

public class Exposure {

	private UUID patientId;

	private LocalDateTime dateTime;

	private String exposureType; // D or I

	@Override
	public String toString() {
		return "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getExposureType() {
		return exposureType;
	}

	public void setExposureType(String exposureType) {
		if(!(exposureType=="D" ||exposureType=="I" )) {
			throw new IllegalArgumentException();
		}
			
		this.exposureType = exposureType;
	}
}

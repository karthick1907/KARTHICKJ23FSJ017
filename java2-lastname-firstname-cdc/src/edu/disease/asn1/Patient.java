package edu.disease.asn1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Patient {

	private UUID patientId;

	private String firstName;

	private String lastName;

	private Exposure[] exposures;

	private UUID[] diseaseIds;
	
	//for array size calculation
	private int topOfDiseaseId;
	private int topOfExposure;

	/* Constructor */
	public Patient(int maxDis, int maxExp) {

		exposures = new Exposure[maxExp];

		diseaseIds = new UUID[maxDis];
		topOfDiseaseId=0;
		topOfExposure=0;
	}

	/* Methods */
	public void addDiseaseId(UUID dId) {
		int n=diseaseIds.length;
		//topOfDiseaseId --> 0 add and plus
		if(topOfDiseaseId>=n) {
			System.out.println("Array is Full!!!");
			return;
		}
		diseaseIds[topOfDiseaseId++]=dId;
		
		
	}

	public void addExposure(Exposure exposure) {
		int n=exposures.length;
		//topOfExposure --> 0 add and plus
		if(topOfExposure>=n) {
			System.out.println("Array is Full!!!");
			return;
		}
		exposures[topOfExposure++]=exposure;
	}

	/* OVER RIDE */
	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds) + "]";
	}

	public UUID getPatientId() {
		return patientId;
	}

	
	/*GET AND SET METHODS*/
	public void setPatientId(UUID patientId) {
		
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Exposure[] getExposures() {
		return exposures;
	}

	public void setExposures(Exposure[] exposures) {
		this.exposures = exposures;
	}

	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	
}

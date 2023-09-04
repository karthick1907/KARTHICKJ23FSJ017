package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public interface DiseaseControlManager {

	public Disease addDisease(String diseaseName,boolean infected);
	public Disease getDisease(UUID diseaseId);
	public Patient addPatient(String firstName,String lastName,int maxDisease,int maxExposure);
	public Patient getPatient(UUID patientID);
	public void addDiseaseToPatient(UUID patientId,UUID diseaseId);
	public void addExposureToPatient(UUID patientId,Exposure exposure);
}

package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImpl implements DiseaseControlManager {

	public DiseaseControlManagerImpl() {
	
		System.out.println("Object Created!!!");// TODO Auto-generated constructor stub
	}
	private Disease diseases[];

	private Patient patients[];

	// for array size calculation
	private int topOfDisease;
	private int topOfPatient;

	public DiseaseControlManagerImpl(int diseaseCount, int patientCount) { 
		System.out.println("Object Created!!!");
		diseases = new Disease[diseaseCount];
		patients = new Patient[patientCount];
		topOfDisease = 0; 
		topOfPatient = 0;
	}

	@Override
	public Disease addDisease(String diseaseName, boolean infected) { 
		Disease di;
		
		if(infected) {
			 di=new InfectiousDisease();
			 di.setDiseaseId(UUID.randomUUID());
			 di.setName(diseaseName);
			 
		}else {
			di=new NonInfectiousDisease();
			 di.setDiseaseId(UUID.randomUUID());
			 di.setName(diseaseName);
		}
		
		if(topOfDisease>=diseases.length) {
			System.out.println("Size is Full!! Not Added!!!");
			return di;
		}
		diseases[topOfDisease++]=di;
		
		return di;
	}

	@Override
	public Disease getDisease(UUID diseaseId) { 
		
		int flag=0;
		
		for(int i=0;i<topOfDisease;i++) {
			Disease d=diseases[i];
			if(d.getDiseaseId().equals(diseaseId)) {
				flag++;
				return d;
			}
		}
		if(flag==0) {
			System.out.println("Not FOund!!!");
		}
		
		return null;
	}

	@Override
	public Patient addPatient(String firstName, String lastName, int maxDisease, int maxExposure) {
		
		Patient p=new Patient(maxDisease,maxExposure);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setPatientId(UUID.randomUUID());
		
		/*Adding Patient*/
		if(topOfPatient>=patients.length) {
			System.out.println("Can't Add!!!");
			return p;
		}
		patients[topOfPatient++]=p;
		
		return p;
	}

	@Override
	public Patient getPatient(UUID patientID) {
		
		if(topOfPatient==0) {
			System.out.println("Array Is Empty!!!");
			return null;
		}
		int flag=0;
		for(int i=0;i<topOfPatient;i++) {
			Patient p = patients[i];
			if(p.getPatientId().equals(patientID)) {
				flag++;
				return p;
			}
		}
		if(flag==0) {
			System.out.println("Not Found!!!");
		}

		return null;
	}

	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		Patient patient = getPatient(patientId);
		if(patient==null) {
			System.out.println("Patient Not Found!!!");
			return;
		}
		Disease disease = getDisease(diseaseId);
		if(disease==null) {
			System.out.println("Disease is not found!!!");
			return;
		}
		//disease id --> add to patient
		UUID dId = disease.getDiseaseId();
		patient.addDiseaseId(dId);
		System.out.println("Disease id added successfull!!!");
		
	}

	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		Patient patient = getPatient(patientId);
		if(patient==null) {
			System.out.println("Patient not Found!!!");
			return;
		}
		patient.addExposure(exposure);
		System.out.println("Exposure added successfull!!!");
	}
	
	/*Get and Set Methods*/
	public Disease[] getDiseases() {
		return diseases;
	}

	public void setDiseases(Disease[] diseases) {
		this.diseases = diseases;
	}

	public Patient[] getPatients() {
		return patients;
	}

	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}


}

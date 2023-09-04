package edu.disease.asn2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiseaseTest {

	private Disease infected;
	private Disease nonInfected;

	@BeforeEach
	void setUp() {

		UUID diseaseId = UUID.randomUUID();
		String diseaseName = "C";

		UUID diseaseId2 = UUID.randomUUID();
		String diseaseName2 = "D";

		infected = new InfectiousDisease();
		infected.setDiseaseId(diseaseId);
		infected.setName(diseaseName);

		nonInfected = new NonInfectiousDisease();
		nonInfected.setDiseaseId(diseaseId2);
		nonInfected.setName(diseaseName2);

	}

	@Test
	public void dieaseSetAndGetMethods() {
//		System.out.println("Before : " + infected);
		String name = "Test Disease";
		infected.setName(name);
		assertEquals(name, infected.getName());
		UUID uuid = UUID.randomUUID();
		infected.setDiseaseId(uuid);
		assertEquals(uuid, infected.getDiseaseId());
//		System.out.println("After : " + infected);

	}

	@Test
	void testEqualsAndHashCode() {
		Set<Disease> hm = new HashSet<>();
		UUID diseaseId = UUID.randomUUID();
		String diseaseName = "C";

		UUID diseaseId2 = UUID.randomUUID();
		String diseaseName2 = "D";

		Disease infectedd = new InfectiousDisease();
		infectedd.setDiseaseId(diseaseId);
		infectedd.setName(diseaseName);

		Disease nonInfectedd = new NonInfectiousDisease();
		nonInfectedd.setDiseaseId(diseaseId2);
		nonInfectedd.setName(diseaseName2);

		/* One */
		hm.add(nonInfectedd);
		hm.add(infectedd);
//		System.out.println("hm.size() : " + hm.size());
//		System.out.println(hm);
		assertEquals(hm.size(), 2);

		Set<Disease> hm2 = new HashSet<>();
		UUID diseaseId11 = UUID.randomUUID();
		String diseaseName11 = "D";

		String diseaseName12 = "D";

		Disease i1 = new InfectiousDisease();
		i1.setDiseaseId(diseaseId11);
		i1.setName(diseaseName11);

		Disease ni2 = new NonInfectiousDisease();
		ni2.setDiseaseId(diseaseId11);
		ni2.setName(diseaseName12);

	
		/* Two */
		hm2.add(i1);
		hm2.add(ni2);
		System.out.println("Ahm2.size() : " + hm2.size());
		System.out.println(hm2);
		assertEquals(hm2.size(), 1);

	}

}

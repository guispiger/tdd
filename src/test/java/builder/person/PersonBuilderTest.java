package builder.person;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PersonBuilderTest {
	final String firstName  = "Guilherme";
	final String middleName = "Baumgratz";
	final String lastName   = "Spiger";
	final String gender             	= "M";
	final String motherFullName 		= "Mãe do Gui";
	final String fatherFullName 		= "Pai do Gui";
	final LocalDate birthDate       	= LocalDate.of(2020, 10, 25);
	final float heightInCentimeters 	= 198.57f;
	final float weightInKilograms   	= 80.55f;
	final String ethnicity              = "white";
	final String specialCharacteristics = "Very ugly";
	
	private Person createPersonWithFullName() {
		PersonBuilder personBuilder = new PersonBuilder();
		return personBuilder.firstName(firstName)
							.midleName(middleName)
							.lastName(lastName)
							.build();
	}
	
	private Person createPersonWithFullData() {
		PersonBuilder personBuilder = new PersonBuilder();
		return personBuilder.firstName(firstName)
							.midleName(middleName)
							.lastName(lastName)
							.gender(gender)
							.motherFullName(motherFullName)
							.fatherFullName(fatherFullName)
							.birthDate(birthDate)
							.heightInCentimeters(heightInCentimeters)
							.weightInKilograms(weightInKilograms)
							.ethnicity(ethnicity)
							.specialCharacteristics(specialCharacteristics)
							.build();
	}
	
	private Person createPersonWithoutMiddleName() {
		PersonBuilder personBuilder = new PersonBuilder();
		return personBuilder.firstName(firstName)
							.lastName(lastName)
							.build();
	}
	
	@Test
	void shouldCreatePersonObjectWithPartialData() {
		final String firstName  = "Guilherme";
		final String middleName = "Baumgratz";
		final String lastName   = "Spiger";

		Person person = createPersonWithFullName();

		assertEquals(firstName, person.getFirstName());
		assertEquals(middleName, person.getMidleName());
		assertEquals(lastName, person.getLastName());
	}

	@Test
	void shouldCreatePersonObjectWithAllData() {		
		Person person = createPersonWithFullData();

		assertEquals(firstName, person.getFirstName());
		assertEquals(middleName, person.getMidleName());
		assertEquals(lastName, person.getLastName());
		assertEquals(gender, person.getGender());
		assertEquals(motherFullName, person.getMotherFullName());
		assertEquals(birthDate, person.getBirthDate());
		assertEquals(heightInCentimeters, person.getHeightInCentimeters());
		assertEquals(weightInKilograms, person.getWeightInKilograms());
		assertEquals(ethnicity, person.getEthnicity());
		assertEquals(specialCharacteristics, person.getSpecialCharacteristics());
	}
	
	@Test
    void shouldReturnFullName() {
		final String fullName   = firstName+" " +middleName+" " +lastName;
		
		Person person = createPersonWithFullName();
		
		assertTrue(fullName.equals(person.getFullName()));
	}
	
	@Test
    void shouldReturnFullNameWithoutMIddleName() {
		final String nameWithoutMiddleName   = firstName+ " " +lastName;
		
		Person person = createPersonWithoutMiddleName();
		
		assertTrue(nameWithoutMiddleName.equals(person.getFullName()));
	}

}

package builder.person;

import java.time.LocalDate;

public final class PersonBuilder {
	private String    firstName              = "";
	private String    midleName              = "";
	private String    lastName               = "";
	private String    gender                 = "";
	private String    motherFullName         = ""; 
	private String    fatherFullName         = "";
	private LocalDate birthDate              = LocalDate.MIN;
	private float     heightInCentimeters    = Float.NaN;
	private float     weightInKilograms      = Float.NaN;
	private String    ethnicity              = "";
	private String    specialCharacteristics = "";
	
	public final Person build() {
		Person person = new Person();
		
		person.setBirthDate(birthDate);
		person.setEthnicity(ethnicity);
		person.setFatherFullName(fatherFullName);
		person.setFirstName(firstName);
		person.setGender(gender);
		person.setHeightInCentimeters(heightInCentimeters);
		person.setLastName(lastName);
		person.setMidleName(midleName);
		person.setMotherFullName(motherFullName);
		person.setSpecialCharacteristics(specialCharacteristics);
		person.setWeightInKilograms(weightInKilograms);
		
		return person;
	}
	
	public final PersonBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public final PersonBuilder midleName(String midleName) {
		this.midleName = midleName;
		return this;
	}
	public final PersonBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public final PersonBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}
	public final PersonBuilder motherFullName(String motherFullName) {
		this.motherFullName = motherFullName;
		return this;
	}
	public final PersonBuilder fatherFullName(String fatherFullName) {
		this.fatherFullName = fatherFullName;
		return this;
	}
	public final PersonBuilder birthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	public final PersonBuilder heightInCentimeters(float heightInCentimeters) {
		this.heightInCentimeters = heightInCentimeters;
		return this;
	}
	public PersonBuilder weightInKilograms(float weightInKilograms) {
		this.weightInKilograms = weightInKilograms;
		return this;
	}
	public final PersonBuilder ethnicity(String ethnicity) {
		this.ethnicity = ethnicity;
		return this;
	}
	public final PersonBuilder specialCharacteristics(String specialCharacteristics) {
		this.specialCharacteristics = specialCharacteristics;
		return this;
	}
	
	//----------------------------------------------------------------	
	
	
}

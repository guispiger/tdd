package builder.person;

import java.time.LocalDate;

public class Person
{
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
		
	public String getFullName() {
		String fullName = null;
		
		fullName = this.firstName;
		
		if(!this.midleName.isBlank() || !this.midleName.isEmpty()) {
			fullName = fullName + " " + midleName;
		}
		
		fullName = fullName + " " + this.lastName;
		
		return fullName;
	}
	
	//----------------------------------------------------------------	
	Person() {
		super();
	}
	
	//----------------------------------------------------------------
	public final 
	String getFirstName()
	{
		return firstName;
	}
	
	//----------------------------------------------------------------
	public final 
	void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	//----------------------------------------------------------------
	public final 
	String getMidleName()
	{
		return midleName;
	}
	
	//----------------------------------------------------------------
	public final 
	void setMidleName(String midleName) 
	{
		this.midleName = midleName;
	}
	
	//----------------------------------------------------------------
	public final 
	String getLastName() 
	{
		return lastName;
	}
	
	//----------------------------------------------------------------
	public final 
	void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	//----------------------------------------------------------------
	public final 
	String getGender() 
	{
		return gender;
	}
	
	//----------------------------------------------------------------
	public final 
	void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	//----------------------------------------------------------------
	public final 
	String getMotherFullName() 
	{
		return motherFullName;
	}
	
	//----------------------------------------------------------------
	public final 
	void setMotherFullName(String motherFullName) 
	{
		this.motherFullName = motherFullName;
	}
	
	//----------------------------------------------------------------
	public final 
	String getFatherFullName() 
	{
		return fatherFullName;
	}
	
	//----------------------------------------------------------------
	public final 
	void setFatherFullName(String fatherFullName) 
	{
		this.fatherFullName = fatherFullName;
	}
	
	//----------------------------------------------------------------
	public final 
	LocalDate getBirthDate() 
	{
		return birthDate;
	}
	
	//----------------------------------------------------------------
	public final 
	void setBirthDate(LocalDate birthDate) 
	{
		this.birthDate = birthDate;
	}
	
	//----------------------------------------------------------------
	public final 
	float getHeightInCentimeters() 
	{
		return heightInCentimeters;
	}
	
	//----------------------------------------------------------------
	public final 
	void setHeightInCentimeters(float heightInCentimeters) 
	{
		this.heightInCentimeters = heightInCentimeters;
	}
	
	//----------------------------------------------------------------
	public final 
	float getWeightInKilograms() 
	{
		return weightInKilograms;
	}
	
	//----------------------------------------------------------------
	public final 
	void setWeightInKilograms(float weightInKilograms) 
	{
		this.weightInKilograms = weightInKilograms;
	}
	
	//----------------------------------------------------------------
	public final 
	String getEthnicity()
	{
		return ethnicity;
	}
	
	//----------------------------------------------------------------
	public final 
	void setEthnicity(String ethnicity) 
	{
		this.ethnicity = ethnicity;
	}
	
	//----------------------------------------------------------------
	public final 
	String getSpecialCharacteristics() 
	{
		return specialCharacteristics;
	}
	
	//----------------------------------------------------------------
	public final 
	void setSpecialCharacteristics(String specialCharacteristics) 
	{
		this.specialCharacteristics = specialCharacteristics;
	}
	
	
	//----------------------------------------------------------------
	@Override
	public final
	String toString() 
	{
		return "Person [ firstName = " + firstName 
				+ ",\n midleName = " + midleName
				+ ",\n lastName = " + lastName 
				+ ",\n gender = "+ gender 
				+ ",\n motherFullName = " + motherFullName 
				+ ",\n fatherFullName = " + fatherFullName 
				+ ",\n birthDate = " + birthDate 
				+ ",\n heightInCentimeters = " + heightInCentimeters 
				+ ",\n weightInKilograms = " + weightInKilograms 
				+ ",\n ethnicity = " + ethnicity 
				+ ",\n specialCharacteristics = " + specialCharacteristics
				+ "]";
	}
}

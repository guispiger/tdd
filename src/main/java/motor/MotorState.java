package motor;

public interface MotorState extends Cloneable
{
	static enum Status { ON , OFF };
	
	Status currentStatus();
	float rotationsPerMinute();
	float accelerationFraction();
	
	void setCurrentStatus(Status newValue);
	void setRotationsPerMinute(float newValue);
	void setAccelerationFraction(float newValue);
	
	public MotorState clone();
	
	public static String stringfy(MotorState motorState)
	{
		return "{ currentStatus: " + motorState.currentStatus()
			+ " rpm: " + motorState.rotationsPerMinute()
			+ " accelerationFraction: " + motorState.accelerationFraction() 
			+ " }";
	}	
}



package motor.abstractMotor;

import motor.MotorState;

public class SimpleMotorState implements MotorState
{
	private Status currentStatus = Status.OFF;
	private float rotationsPerMinute = 0.0f;
	private float accelerationFraction = 0.0f;
	
	//----------------------------------------------------------
	public SimpleMotorState( 
            Status currentStatus, 
            float rotationsPerMinute, 
            float accelerationFraction )
	{
		super();
		this.currentStatus = currentStatus;
		this.rotationsPerMinute = rotationsPerMinute;
		this.accelerationFraction = accelerationFraction;
	}

	//----------------------------------------------------------
	@Override
	public MotorState.Status currentStatus()
	{
		return currentStatus;
	}

	//----------------------------------------------------------
	@Override
	public float rotationsPerMinute()
	{
		return rotationsPerMinute;
	}

	//----------------------------------------------------------
	@Override
	public float accelerationFraction()
	{
		return accelerationFraction;
	}

	//----------------------------------------------------------
	@Override
	public MotorState clone()
	{
	   try 
	   {
	      Object clone = super.clone();
	      return (MotorState)clone;
	   } 
	   catch (CloneNotSupportedException e) 
	   {
	      //should never be executed
	      e.printStackTrace();
	      return null;
	   }
	}
	//----------------------------------------------------------
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof SimpleMotorState)) {
			return false;
		}
		
		SimpleMotorState another = (SimpleMotorState) other;
		
		
		boolean equals = (this.currentStatus() == another.currentStatus() &&
				          areEquals(this.rotationsPerMinute(), another.rotationsPerMinute()) &&
				          areEquals(this.accelerationFraction(), another.accelerationFraction()));
		
		return equals;
	}
	//----------------------------------------------------------
	private boolean areEquals(float f1, float f2) {
//		final double threshold = .0001f;
//		return (Math.abs(f1 - f2) < threshold);
		return (Float.compare(f1, f2) == 0);
	}
	
	//----------------------------------------------------------
	@Override
	public void setCurrentStatus(Status newValue) {
		this.currentStatus = newValue;
		
	}
	//----------------------------------------------------------
	@Override
	public void setRotationsPerMinute(float newValue) {
		this.rotationsPerMinute = newValue;
		
	}
	//----------------------------------------------------------
	@Override
	public void setAccelerationFraction(float newValue) {
		this.accelerationFraction = newValue;
		
	}
	
}

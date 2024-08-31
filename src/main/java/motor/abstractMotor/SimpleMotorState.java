package motor.abstractMotor;

import motor.MotorState;

public class SimpleMotorState implements MotorState
{
	Status currentStatus = Status.OFF;
	float rpm = 0.0f;
	float accelerationFraction = 0.0f;
	
	//----------------------------------------------------------
	public SimpleMotorState( 
            Status currentStatus, 
            float rpm, 
            float accelerationFraction )
	{
		super();
		this.currentStatus = currentStatus;
		this.rpm = rpm;
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
		return rpm;
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
	
	private boolean areEquals(float f1, float f2) {
//		final double threshold = .0001f;
//		return (Math.abs(f1 - f2) < threshold);
		return (Float.compare(f1, f2) == 0);
	}
	
}

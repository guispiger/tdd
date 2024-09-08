package motor.event;

import motor.Motor;
import motor.MotorState;

public class MotorEvent {
	public final Motor source;
	public final MotorState state;
	
	public MotorEvent(Motor source, MotorState state) {
		this.source = source;
		this.state = state;
	}
	
	
}

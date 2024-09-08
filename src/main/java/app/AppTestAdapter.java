package app;

import fusca.motor.Motor1500;
import motor.Motor;
import motor.MotorState;
import motor.event.MotorEvent;
import motor.event.listenerOldStyle.MotorEventListener;
import motor.event.listenerOldStyle.MotorEventListenerAdapter;
import motor.observable.ObservableMotor;

public class AppTestAdapter {

	ObservableMotor motor = null;

	MotorEventListener speedMotorListener = new MotorEventListenerAdapter() {
		@Override
		public void beforeSpeedUp(MotorEvent me) {
			System.out.println("beforeSpeedUp " + MotorState.stringfy(me.state));
		}

		@Override
		public void afterSpeedUp(MotorEvent me) {
			System.out.println("afterSpeedUp " + MotorState.stringfy(me.state));
		}

	};

	MotorEventListener stopMotorListener = new MotorEventListenerAdapter() {
		@Override
		public void beforeStop(MotorEvent me) {
			System.out.println("beforeStop " + MotorState.stringfy(me.state));
		}

		@Override
		public void afterStop(MotorEvent me) {
			System.out.println("afterStop " + MotorState.stringfy(me.state));
		}
	};

	// ----------------------------------------------------------------------------
	public AppTestAdapter() {
		Motor motor1500 = new Motor1500();
		this.motor = new ObservableMotor(motor1500);
	}

	// ----------------------------------------------------------------------------
	public static void main(String args[]) {
		AppTestAdapter app = new AppTestAdapter();
		
		app.motor.addMotorListener(app.speedMotorListener);
		app.motor.addMotorListener(app.stopMotorListener);
		
		app.motor.start();
		app.motor.speedUp(0.5f);
		app.motor.stop();
	}
}

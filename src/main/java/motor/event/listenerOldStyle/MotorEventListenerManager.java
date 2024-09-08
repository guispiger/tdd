package motor.event.listenerOldStyle;

import java.util.ArrayList;
import java.util.List;

import motor.event.MotorEvent;

public class MotorEventListenerManager {
	private List<MotorEventListener> listeners = new ArrayList<>();
	
	public void addMotorListener(MotorEventListener listener) {
		listeners.add(listener);
	}
	
	public void removeMotorListener(MotorEventListener listener) {
		listeners.remove(listener);
	}
	
	public void fireBeforeStart(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeStart(me);
		}
	}
	
	public void fireBeforeStop(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeStop(me);
		}
	}

	public void fireBeforeSlowDown(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeSlowDown(me);
		}
	}

	public void fireBeforeSpeedUp(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeSpeedUp(me);
		}
	}
	
	public void fireAfterStart(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeStart(me);
		}
	}
	
	public void fireAfterStop(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeStop(me);
		}
	}

	public void fireAfterSlowDown(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeSlowDown(me);
		}
	}

	public void fireAfterSpeedUp(MotorEvent me) {
		for (MotorEventListener motorEventListener : listeners) {
			motorEventListener.beforeSpeedUp(me);
		}
	}
	
}

package app;

import fusca.motor.Motor1500;
import motor.Motor;
import motor.MotorState;
import motor.event.MotorEvent;
import motor.event.listenerOldStyle.MotorEventListener;
import motor.observable.ObservableMotor;

public class AppTest
{
   private ObservableMotor motor = null;
	
   private MotorEventListener motorListener = new MotorEventListener() 
   {
      @Override
      public void beforeStart(MotorEvent me)
      { System.out.println("beforeStart " + MotorState.stringfy(me.state)); }

      @Override
      public void afterStart(MotorEvent me) 
      { System.out.println("afterStart " + MotorState.stringfy(me.state)); }

      @Override
      public void beforeStop(MotorEvent me)
      { System.out.println("beforeStop " + MotorState.stringfy(me.state)); }

      @Override
      public void afterStop(MotorEvent me)
      { System.out.println("afterStop " + MotorState.stringfy(me.state)); }
      
      @Override
      public void beforeSlowDown(MotorEvent me)
      { System.out.println("beforeSlowDown " + MotorState.stringfy(me.state)); }

      @Override
      public void afterSlowDown(MotorEvent me)
      { System.out.println("afterSlowDown " + MotorState.stringfy(me.state)); }

      @Override
      public void beforeSpeedUp(MotorEvent me)
      { System.out.println("beforeSpeedUp " + MotorState.stringfy(me.state)); }

      @Override
      public void afterSpeedUp(MotorEvent me)
      { System.out.println("afterSpeedUp " + MotorState.stringfy(me.state)); }
   };

   //----------------------------------------------------------------------------
   public AppTest()
   {
	   Motor motor1500 = new Motor1500();
	   motor = new ObservableMotor(motor1500);
       motor.addMotorListener(motorListener);
   }

   //----------------------------------------------------------------------------
   public static void main(String args[])
   {
      AppTest app = new AppTest();
      
      app.motor.start();
      app.motor.speedUp(0.5f);
      app.motor.stop();
   }

}

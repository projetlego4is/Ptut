package Nelson;
import Hugo.CompassSensor;
import Nico.LineLeader;
import lejos.nxt.addon.CompassHTSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

public class WallE
{
	public DifferentialPilot robot;	
	public CompassSensor boussole;
	public LineLeader lineleader;

	public WallE() 
	{
		this.robot = new DifferentialPilot(5.4, 11.1, Motor.B, Motor.C, true);
		this.robot.setTravelSpeed(5);
		this.robot.setRotateSpeed(50);	
		this.boussole = new CompassSensor(SensorPort.S1);
		this.lineleader = new LineLeader(SensorPort.S4);

	}


	//************************************************************************************************//
	//*****************fonction qui s'occupe du déplacement du robot**********************************//
	//************************************************************************************************//
	public void avancerWallE(double d)
	{


		//this.robot.reset();//reset de tacho count
		this.robot.travel(-d);

	}

	public void tournerWallE(boolean sens,float angle)
	{
		this.robot.reset();//reset de tacho count
		// Si sens = true on tourne à droite
		// Si sens=
		this.robot.setRotateSpeed(50);	
		if (sens)
		{
			this.robot.rotate(angle);
		}
		else
		{
			this.robot.rotate(angle);
		}
	}


	public void tournerWallE(int angle)
	{
		this.robot.reset();//reset de tacho count
		angle= angle % 360;
		if(angle>180){
			angle=angle-360;
		}
		this.robot.rotate(angle);
	}	



	public void tournerWallE_centre(float angle)
	{
		this.avancerWallE(7.2);
		this.robot.reset();//reset de tacho count
		angle= angle %360;
		angle=angle-180;
		this.robot.rotate(angle);
		avancerWallE(-7.2);
	}	

	public void tournerWallE_centre(boolean sens,float angle)
	{
		this.robot.reset();//reset de tacho count
		avancerWallE(7.2);

		if (sens)
		{
			this.robot.rotate(angle);
		}
		else
		{
			this.robot.rotate(angle);
		}
		avancerWallE(-7.2);
	}
	
	public void testRotate(){
		this.tournerWallE(30);
		this.tournerWallE(-30);
		this.avancerWallE(10);
		this.avancerWallE(-10);
	}
}
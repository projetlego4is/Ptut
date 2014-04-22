package Hugo;

import lejos.nxt.Button;
import lejos.nxt.I2CPort;
import lejos.nxt.addon.CompassHTSensor;
import Nelson.*;


public class CompassSensor extends CompassHTSensor {	
	
	/*CONSTRUCTEUR*/
	public CompassSensor (I2CPort port){
		super(port);
	}
	
	//calibrage de la boussole
	public static void calibrageBoussole(WallE robotWallE){
		robotWallE.robot.setRotateSpeed(20);
		robotWallE.robot.rotateLeft();
		Button.waitForAnyPress();
		robotWallE.boussole.startCalibration();
		System.out.println("Appuyer un bouton quand le robot aura fait deux tours");
		Button.waitForAnyPress();
		robotWallE.boussole.stopCalibration();
		// Attendre deux tours du robot et appuyer sur un bouton sans déplacer le robot
		//robotWallE.robot.stop();
	}

	public static void testBoussole(WallE monRobot) {
		float direction;
		monRobot.robot.setRotateSpeed(0);
		monRobot.boussole.resetCartesianZero(); //le robot doit être suivant l'axe des x pour mettre le zero
		direction = monRobot.boussole.getDegreesCartesian() ;
		System.out.println(direction);
		Button.waitForAnyPress();
		monRobot.robot.setRotateSpeed(60);
		monRobot.robot.rotate(70);
		direction = monRobot.boussole.getDegreesCartesian() ;
		System.out.println(direction);
	}
	/*public static void recuperationDegre(WallE robotWallE){
		System.out.println("degre = " + robotWallE.boussole.getDegrees());
		}*/
	
	// Attendre deux tours du robot et appuyer sur un bouton sans déplacer le robot
	public static void main(String[] args) {	
		
		WallE monRobot= new WallE();
		
		calibrageBoussole(monRobot);
		testBoussole(monRobot);
		Button.waitForAnyPress();
		
		//recuperationDegre(monRobot);
	}

}


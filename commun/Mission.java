package commun;

import lejos.nxt.Button;
import Bapt.Strategie;
import Nelson.WallE;

public class Mission {

	public static void main(String[] args)	
	{

		System.out.println("Hello boby");	

		WallE rob = new WallE();
		Strategie strat = new Strategie(rob);


		//strat.testAvancer();
		//strat.robot.tournerWallE(90);
		strat.atteindreObjectif(20);
		//robotkikoo.testRotate();
		//rob.boussole.calibrageBoussole(rob);
		//rob.boussole.testBoussole(rob);
		//Button.waitForAnyPress();

	}
}

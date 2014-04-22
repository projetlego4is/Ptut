package Nico;
//import lejos.nxt.Button;

import Nelson.WallE;
import lejos.nxt.Button;
import lejos.nxt.I2CPort;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.NXTLineLeader;


public class LineLeader extends NXTLineLeader {	
	
	private int port;
	
	private static final LineColor LineColor = null;
	public NXTLineLeader.LineColor color;
	public static int TabCapteur[];
	
	/*CONSTRUCTEUR*/
	public LineLeader (I2CPort port){
		super(port);
		if(port == SensorPort.S4)
			this.port = 4;
	}
	

	/*METHODES*/
	
	//Calibre le capteur
/*	public static void CalibrerCapteur(WallE robotWallE)
	{
		robotWallE.lineleader = new LineLeader (SensorPort.S4);
		
		robotWallE.lineleader.wakeUp(); //reveille le capteur
		
		System.out.println("mettre un objet noir sous le LineLeader");
		robotWallE.lineleader.calibrate(LineColor);
		robotWallE.lineleader.getCalibrationData(BLACK, LineColor);
		
		Button.waitForAnyPress();
		robotWallE.robot.stop();	
	}
*/
	
	public static void etalonnerHigh()
	{
		WallE rob = new WallE();
		//Boutons b = new Boutons();
		System.out.println(" placer du blanc et appuyer sur un bouton ");
		Button.waitForAnyPress();
		System.out.println(" aatchoum! ");
		rob.lineleader.getCalibrationData(WHITE, LineColor);
		System.out.println("High : " + rob.lineleader.getCalibrationData(WHITE, LineColor));
	}
	
	public static void etalonnerLow()
	{
		WallE rob = new WallE();
		//Boutons b = new Boutons();
		System.out.println(" placer du noir ");
		Button.waitForAnyPress();
		rob.lineleader.getCalibrationData(BLACK, LineColor);
		System.out.println("Low : " + rob.lineleader.getCalibrationData(BLACK, LineColor));
	}
	
	
	public static void etalonner()
	{
		/* On va Ã©talonner le capteur entre la valeur low (noir) et la valeur high (blanc)
		 * en passant par la valeur mid
		 */
		etalonnerHigh();
		etalonnerLow();
	}
	
	//au dela de cette valeur 
/*	public static int LimiteUtilisation(WallE robotWallE)
	{
		robotWallE.lineleader = new LineLeader (SensorPort.S4);
		
		robotWallE.lineleader.wakeUp(); //reveille le capteur
		
		if (robotWallE.lineleader.getReadingLimit(BLACK, null) == -1)
			System.out.println("erreur de lecture");
		
		return robotWallE.lineleader.getReadingLimit(BLACK, null);
	}
*/
	
	// probablement inutile maintenant...
/*	public static int Direction(WallE robotWallE)
	{
		robotWallE.lineleader = new LineLeader (SensorPort.S4);
		
		robotWallE.lineleader.wakeUp(); //reveille le capteur
		
		if (robotWallE.lineleader.getCalibratedSensorReading(BLACK) == -1)
		System.out.println("probleme avec le capteur");
	
		return robotWallE.lineleader.getCalibratedSensorReading(BLACK);
	}
*/	
	
	//fonction qui va récupérer les valeurs de chaque capteur
/*	public static int[] ProcedureRecalage(WallE robotWallE)  //on va considérer qu'une ligne aura une largeur de 6 capteurs
	{
		int index=1;
		int capt1=0, capt2=0, capt3=0, capt4=0, capt5=0, capt6=0, capt7=0, capt8=0;
		
		robotWallE.lineleader = new LineLeader (SensorPort.S4);
		
		robotWallE.lineleader.wakeUp(); //reveille le capteur
		
		for(index=1; index<=8; index++)
		{
			switch(index)
			{
			case 1:
				capt1 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 2:
				capt2 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 3:
				capt3 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 4:
				capt4 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 5:
				capt5 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 6:
				capt6 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 7:
				capt7 = robotWallE.lineleader.getCalibratedSensorReading(index);
			case 8:
				capt8 = robotWallE.lineleader.getCalibratedSensorReading(index);
			}
			
			TabCapteur = new  int[8];
			TabCapteur[index] = robotWallE.lineleader.getCalibratedSensorReading(index);
			
			if (robotWallE.lineleader.getCalibratedSensorReading(index) >= robotWallE.lineleader.getAverage())//ou alors on compare à 0 (a voir)
				//le capteur voit qqch
				System.out.println("le capteur " + index + "capte un signal");	
		}
		
		if(capt1!= 0 || capt8 != 0)
			System.out.println("le robot est mal recale");
		//continue recalage
		else
		{
			if(capt1 == 0 && capt8 == 0 &&  capt7 != 0 && capt6 != 0 && capt5 != 0 && capt4 != 0 && capt3 != 0 && capt2 != 0)
				System.out.println("le robot est bien recalé!!");
		}
		
		return TabCapteur;
	}
*/	
		
	public static void main(String[] args) {	
		//WallE rob= new WallE();
		//CalibrerCapteur(rob);
		//ProcedureRecalage(rob);
		etalonner();
	}
}
package Bapt;
import lejos.nxt.Button;
import Nelson.WallE;

public class Strategie extends Thread {

	protected WallE robot;	
	//protected UltrasonicSensor sonar;	
	//protected LightSensor ls ;

	public Strategie(WallE robotNelson) {
		super();
		this.robot = robotNelson;
		//this.sonar =new UltrasonicSensor(SensorPort.S2);
		//this.ls = new LightSensor(SensorPort.S3);
	}

	// fonction permettant de balancer une zone carrï¿½e de 2*rayon de largeur
	public void atteindreObjectif(int rayon){
		boolean objAtteint = false;
		int i=0;
		int l_parc = 0; // largeurparcourue
		int largeur_capteur=10 ; // largeur de balayage du capteur de lignes
		int angle = 90;
		int vitesse = 10;

		Button.waitForAnyPress();

		/*		//while (!objAtteint && (i<2)){
			this.robot.avancerWallE(rayon);
			while ((l_parc<rayon)){
				//System.out.println("on avance !");
				this.robot.tournerWallE(angle);
				//System.out.println("on tourne !");
				this.robot.avancerWallE(largeur_capteur);
				this.robot.tournerWallE(angle);
				this.robot.avancerWallE(2*rayon);
				l_parc+=largeur_capteur;

				angle+=180;// on tourne dans l'autre sens pour balayer
				System.out.println(angle);
			}
			// on a atteint le bord de notre carré de recherche, on va de l'autre côté !
			angle+=180;
			l_parc=0;
			this.robot.tournerWallE(angle);
			this.robot.avancerWallE(2*rayon);
			this.robot.tournerWallE(angle);
			this.robot.avancerWallE(2*rayon);

			// on va parcourir l'autre côté !
			while ((l_parc<rayon)){
				//System.out.println("on avance !");
				this.robot.tournerWallE(angle);
				//System.out.println("on tourne !");
				this.robot.avancerWallE(largeur_capteur);
				this.robot.tournerWallE(angle);
				this.robot.avancerWallE(2*rayon);
				l_parc+=largeur_capteur;

				angle+=180;// on tourne dans l'autre sens pour balayer
				System.out.println(angle);
			}*/
		//}	
		/**********************************************************************/
		/* 2ème méthode qui permet de terminer su rle point de départ si on a rien trouvé */
		// scan d'un des 2 côtés de la zone de recherche
		while ((l_parc<rayon)){
			this.robot.avancerWallE(rayon);
			//System.out.println("on avance !");
			this.robot.tournerWallE(angle);
			//System.out.println("on tourne !");
			this.robot.avancerWallE(largeur_capteur);
			this.robot.tournerWallE(angle);
			this.robot.avancerWallE(rayon);
			l_parc+=largeur_capteur;

			angle+=180;// on tourne dans l'autre sens pour balayer
			System.out.println(angle);
		}
		angle+=180;
		l_parc=0;
		this.robot.avancerWallE(rayon);
		this.robot.tournerWallE(angle);
		this.robot.avancerWallE(2*rayon);
		this.robot.tournerWallE(angle);
		this.robot.avancerWallE(rayon);

		// scan du 2ème côté de la zone de recherche
		while ((l_parc<rayon)){
			this.robot.avancerWallE(rayon);
			//System.out.println("on avance !");
			this.robot.tournerWallE(angle);
			//System.out.println("on tourne !");
			this.robot.avancerWallE(largeur_capteur);
			this.robot.tournerWallE(angle);
			this.robot.avancerWallE(rayon);
			l_parc+=largeur_capteur;

			angle+=180;// on tourne dans l'autre sens pour balayer
			System.out.println(angle);
		}
		// si on a rien trouvé

	}

}

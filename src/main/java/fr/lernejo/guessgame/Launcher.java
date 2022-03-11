package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

	public static void main(String[] args) {
		Simulation sim = new Simulation(new HumanPlayer());
		sim.initialize(new SecureRandom().nextLong());
		sim.loopUntilPlayerSucceed();
	}

}

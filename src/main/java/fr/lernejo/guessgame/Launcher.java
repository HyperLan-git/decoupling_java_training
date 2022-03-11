package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

	public static void main(String[] args) {
		Player p = null;
		long iter = 0;
		Long val = null;
		if(args.length < 0) {
			System.out.println("Use an argument : -interactive to play yourself ou -auto to let the computer play");
			return;
		}
		switch(args[0]) {
			case "-auto":
				iter = 1000;
				p = new ComputerPlayer();
				if(args.length > 1) {
					try {
						val = Long.valueOf(args[1]);
					} catch(NumberFormatException e) {}
				}
				break;
			case "-interactive":
				iter = Long.MAX_VALUE;
				p = new HumanPlayer();
				break;
			default:
				System.out.println("Use a valid argument with this program !");
		}
		if(val == null)
			val = new SecureRandom().nextLong();
		Simulation sim = new Simulation(p);
		sim.initialize(val);
		sim.loopUntilPlayerSucceed(iter);
	}

}

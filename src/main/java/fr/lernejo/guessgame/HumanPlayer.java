package fr.lernejo.guessgame;

import java.util.Scanner;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player {
	private Scanner sc = new Scanner(System.in);
	private Logger logger = LoggerFactory.getLogger("player");

	@Override
	public long askNextGuess() {
		long result = 0;
		boolean valid = false;
		while(!valid) {
			try {
				result = Long.valueOf(sc.next());
				valid = true;
			} catch (NumberFormatException e) {
				valid = false;
			}
		}
		return result;
	}

	@Override
	public void respond(boolean lowerOrGreater) {
		if(lowerOrGreater)
			logger.log("The right value is greater !");
		else
			logger.log("The right value is lower !");
	}

}

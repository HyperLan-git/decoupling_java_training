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
			System.out.println("Guess a number !");
			try {
				result = Long.valueOf(sc.next());
				valid = true;
			} catch (NumberFormatException e) {
				logger.log("Not a number !");
				valid = false;
			}
		}
		return result;
	}

	@Override
	public void respond(boolean lowerOrGreater) {
		logger.log("response : " + lowerOrGreater);
		if(lowerOrGreater)
			System.out.println("The right value is greater !");
		else
			System.out.println("The right value is lower !");
	}

}

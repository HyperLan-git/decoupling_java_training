package fr.lernejo.guessgame;

import java.time.Duration;
import java.time.Instant;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
	private final Logger logger = LoggerFactory.getLogger("simulation");
	private final Player player;
	private long numberToGuess;

	public Simulation(Player player) {
		this.player = player;
	}

	public void initialize(long numberToGuess) {
		logger.log("The number is " + numberToGuess);
		this.numberToGuess = numberToGuess;
	}

	/**
	 * @return true if the player have guessed the right number
	 */
	private boolean nextRound() {
		long l = player.askNextGuess();
		logger.log("Player guessed " + l);
		if (l == numberToGuess) {
			logger.log("They guessed right");
			return true;
		}
		logger.log("They guessed wrong");
		player.respond(l < numberToGuess);
		return false;
	}

	public void loopUntilPlayerSucceed(long iter) {
		Instant instant = Instant.now();
		while(!nextRound() && iter-- > 0) {
			Duration d = Duration.between(instant, Instant.now());
			System.out.println(String.format("%02d:%02d.%03d",
					d.toMinutesPart(), d.toSecondsPart(), d.toMillisPart()));
		}
	}
}

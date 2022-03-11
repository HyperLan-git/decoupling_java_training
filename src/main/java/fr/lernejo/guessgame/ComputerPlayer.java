package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {
	private long min = Long.MIN_VALUE, max = Long.MAX_VALUE;
	private long lastGuess = 0;

	@Override
	public long askNextGuess() {
		long c  = (min+max) / 2;
		lastGuess = c;
		return c;
	}

	@Override
	public void respond(boolean lowerOrGreater) {
		if(lowerOrGreater)
			min = lastGuess;
		else
			max = lastGuess;
	}

}

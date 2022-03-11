package fr.lernejo.logger;

public class CompositeLogger implements Logger {
	private final Logger log, log2;
	
	public CompositeLogger(Logger log, Logger log2) {
		this.log = log;
		this.log2 = log2;
	}

	@Override
	public void log(String message) {
		log.log(message);
		log2.log(message);
	}

}

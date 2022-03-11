package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	private final Logger logger;
	private final String name;
	
	public ContextualLogger(Logger logger, String name) {
		this.logger = logger;
		this.name = name;
	}

	@Override
	public void log(String message) {
		logger.log("[" + LocalDateTime.now().format(formatter) + " " + name + "] " + message);
	}

}

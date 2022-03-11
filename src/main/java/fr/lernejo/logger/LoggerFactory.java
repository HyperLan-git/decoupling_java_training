package fr.lernejo.logger;

public class LoggerFactory {
	public static Logger getLogger(String name) {
		return new ContextualLogger(new CompositeLogger(new FileLogger("./logging.log"), new ConsoleLogger()), name);
	}
}

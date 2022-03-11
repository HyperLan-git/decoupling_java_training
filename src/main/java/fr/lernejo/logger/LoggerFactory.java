package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
	public static Logger getLogger(String name) {
		Predicate<String> condition = message -> message.contains("simulation");
		return new ContextualLogger(new CompositeLogger(
				new FilteredLogger(new FileLogger("./logging.log"), condition),
				new ConsoleLogger()
				)
				, name);
	}
}

public interface Config {
	
	final boolean DEBUG = true;
	
	final boolean LOGGING = true;
	final String  LOG_FILENAME = "fuzzer.log"; 
	
	final String UA_CRAWL = "Java Crawler (v.01a), pwarner@pct.edu to stop.";
	final String UA_ABUSE = "Java Fuzzer (v.01a), pwarner@pct.edu to stop.";
	
	final int DEPTH = 2;
}

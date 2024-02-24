import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Log {
	
	/**
	 * Prints to a log file and console
	 */
	public static void log(LogType type, String message) {
		if(!Config.LOGGING) {
			return;
		}
		
		//records look like: 
		//DATE: INFO: MESSAGE \n
		
		//messages must not be empty and can be up to 256 chars.
		String entry = Log.getTimestamp() + ":" + type + ":" + message + "\n";
		
		logf(entry);
		logc(entry);
	}
	
	/**
	 * Prints to a log file and console with more detail
	 */
	public static void log(LogType type, String message, String className, String methodName) {
		if(!Config.LOGGING) {
			return;
		}
		
		//records look like: 
		//DATE: INFO: MESSAGE \n
		
		//messages must not be empty and can be up to 256 chars.
		String entry = Log.getTimestamp() + ":" + type + ":" + className + ":" + methodName + ":" + message + "\n";
		
		logf(entry);
		logc(entry);
	}
	
	/**
	 * Prints the log entry to a file 
	 */
	private static void logf(String entry) {
		FileWriter fw;
		
		try {
			fw = new FileWriter(Config.LOG_FILENAME, true);
			fw.write(entry);
			fw.close();
		} catch (IOException e) {
			if(Config.DEBUG) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Prints the log entry to the console
	 */
	public static void logc(String entry) {
		System.out.println(entry);
	}
	
	/**
	 * Returns timestamp
	 * 
	 * @return
	 */
	private static String getTimestamp() {
		Calendar now = Calendar.getInstance();
		
		String timestamp = now.get(Calendar.YEAR) + "" +
	    		(now.get(Calendar.MONTH) + 1) + "" +
	    		now.get(Calendar.DAY_OF_MONTH) + "" +
	    		"-" + 
	    		now.get(Calendar.HOUR_OF_DAY) + "" +
	    		now.get(Calendar.MINUTE) + "" + 
	    		now.get(Calendar.SECOND) + "";
		
		return timestamp;
	}
}

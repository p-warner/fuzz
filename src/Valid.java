import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
	
	public static boolean url(String input) {
		//length
		if(input.length() < 5 || input.length() > 256)
			return false;
		
		Pattern p = Pattern.compile("^http(s)?:\\/\\/(.*?)\\.[a-z]{2,52}\\/.*$");
		Matcher m = p.matcher(input.toLowerCase());
		
		return m.find();
	}
}

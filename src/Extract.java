import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {

	public static ArrayList<String> formActions(String input) {
		return find(input, "action=\"(.*?)\"");
	}
	
	public static ArrayList<String> formFields(String input) {
		return find(input, "<input.*?name=\"(.*?)\"");
	}
	
	public static ArrayList<String>links(String input) {
		return find(input, "href=\"(.*?)\"");
	}
	
	private static ArrayList<String> find(String input, String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		
		ArrayList<String> matches = new ArrayList<String>();
		
		while(m.find()) {
			matches.add(m.group(1));
		}
		
		return matches;
	}
	
}

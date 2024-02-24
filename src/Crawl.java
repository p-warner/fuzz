import java.util.ArrayList;

public class Crawl {
	
	private String seed, tld, domain, subdomain;
	
	Crawl(String seed){
		if(!Valid.url(seed)) {
			Log.log(LogType.ERROR, "Crawl attempted on non-url " + seed, "Crawl", "Crawl()");
			return;
		}
		
		this.seed = seed;
		
		//parse tld
		
		//parse domain (name, tld)
		
	}
	
	public void init() {
		//Make a HTTP request
		Request r = new Request();
		String response = r.get(this.seed);
		//Log.logc(response.substring(0, 128));
		
		//look for <form>
		ArrayList<String> interesting = Extract.formActions(response);
		Log.logc(interesting.toString());
		
		interesting = Extract.formFields(response);
		Log.logc(interesting.toString());
		
		//look for more URLs to scan
		interesting = Extract.links(response);
		Log.logc(interesting.toString());
	}
}

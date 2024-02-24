import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Request {
	
	public String get(String url) {
		
		Log.log(LogType.INFO, "GET " + url, "Request", "get()");
		
		if(!Valid.url(url)) {
			Log.log(LogType.ERROR, " GET on non URL " + url, this.getClass().getSimpleName(), this.getClass().getEnclosingMethod().getName());
			return null;
		}
		
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			//HTTP is a pplain text protocol by default
			//There are many methods defined in the protocol
			//the most common are GET and POST
			
			//GET means we're asking to receive something
			
			//POST means we're sending data
			//When looking through logs, you should pay attention to POST requests
			
			//THERE ARE MORE, TYPICALLY USED with API endpoints- 
			//put, patch, delete
			
			con.setRequestMethod("GET");
			con.setRequestProperty("user-agent", Config.UA_CRAWL);
			
			int responseCode = con.getResponseCode();
			Log.log(LogType.INFO, responseCode+"");
			
			StringBuffer response = new StringBuffer();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				while((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				in.close();
				
				return response.toString();
			}else {
				return null;
			}
			
		} catch (Exception e) {
			Log.log(LogType.ERROR, "Caught Exception:" + e.getClass().getSimpleName() + ":"+ e.getMessage() );
			
			if(Config.DEBUG) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}

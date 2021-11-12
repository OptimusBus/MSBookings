package innerconnector;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import innerconnector.HttpConnector.Method;

public class HttpConnector {
	
	public HttpConnector() {}
	
	private static Response makeRequest(String url, Method m, Map<String,String> queryParam, String params) {
			
			WebClient client = WebClient.create(baseAddress);
			client.accept("application/json");
			client.type("application/json");
			client.path(url);
			switch(m) {
				case GET:
					if(queryParam != null) {
						for (Entry<String, String> entry : queryParam.entrySet()) {
					        client.query(entry.getKey(), entry.getValue());
					    }
					}
					return client.get();
				case POST:
					if(params != null) return client.post(params);
				case PUT:
					if(params != null) return client.put(params);
				case DELETE:
					if(params != null) return client.delete();
				default:
					return null;
			}
			
	}
	
	public static Response getPassengerByEmail(String email) {
		return makeRequest("/passengers/getByEmail?email="+email,Method.GET,null,null);
	}
	
	public static Response getPassengerByUsername(String username) {
		return makeRequest("/passengers/getByUsername?username="+username,Method.GET,null,null);
	}
		
		

	

	
private static final String baseAddress= "http://gateway-optimusbus.router.default.svc.cluster.local/optimusbus";
public static enum Method {GET, POST, PUT, DELETE}

}

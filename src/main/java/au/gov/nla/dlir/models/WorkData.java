package au.gov.nla.dlir.models;

import java.io.IOException;
import java.net.MalformedURLException;

import au.gov.nla.dlir.util.HttpHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WorkData {
	
	private String jsonString;
	private Work work;
	
	public static WorkData loadFromUrl(String url) {
		return new WorkData(HttpHelper.get(url));
	}
	
	public WorkData(String json) {
		this.jsonString = json;
		loadWork();
	}
	
	private void loadWork() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			work = mapper.readValue(jsonString, Work.class); 
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public String getJsonString() {
		return jsonString;
	}
	
	public Work getWork() {
		return work;
	}
	
}

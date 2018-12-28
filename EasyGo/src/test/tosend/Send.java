package test.tosend;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Send {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").disableHtmlEscaping().create();
	public static String tosend() {
		
		Map<String,Object> map=new HashMap();
		
		map.put("userid", "helloworld2");
		
		map.put("eventType", "1");
		
		map.put("convType", "PERSON");
		
		
		
		
		
		
		
		String params=gson.toJson(map).replaceAll("\"\\[", "\\[").replaceAll("\\]\"", "\\]").replaceAll("\\\\", "").replaceAll("\"\\{", "\\{").replaceAll("\\}\"", "\\}");;
		return params;
		
	}
}

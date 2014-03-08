package com.mss.livesmart;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTest {
	Response[] responseList;

	public Response[] jsonToList() {

		String jsonText = "[ { \"id\": 0, \"recommendation\": \"This is a recommendation.\", \"url\": \"www.health.ca\" },"
				+ "{ \"id\": 1, \"recommendation\": \"This is another recommendation.\", \"url\": \"www.carethy.com\" } ]";

		ObjectMapper objectMapper = null;

		try {
			// Create a new instance of Class ObjectMapper
			objectMapper = new ObjectMapper();

		} catch (Throwable t) {
			t.printStackTrace();
		}

		try {
			responseList = objectMapper.readValue(jsonText, Response[].class);
			System.out.println("responseList length: " + responseList.length);
			for (int i = 0; i < responseList.length; i++) {
				System.out.println(responseList[i].getRecommendation());
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseList;
	}

}

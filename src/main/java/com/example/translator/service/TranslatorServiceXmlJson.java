package com.example.translator.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TranslatorServiceXmlJson {

	public String transform(Object message) throws JsonProcessingException {
				 
		ObjectMapper mapper = new ObjectMapper();		
		String jsonData = mapper.writeValueAsString(message);
		return jsonData;
	}

}

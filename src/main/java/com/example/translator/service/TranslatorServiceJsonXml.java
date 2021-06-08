package com.example.translator.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class TranslatorServiceJsonXml {

	public String transform(Object message) throws JsonProcessingException {

		XmlMapper xmlMapper = new XmlMapper();
		/*
		 * xmlMapper.registerModule(new SimpleModule().addDeserializer( JsonNode.class,
		 * new DuplicateXmlArrayJsonNode() ));
		 */
	  //  return xmlMapper.writer().withoutRootName().writeValueAsString(message);
	    return xmlMapper.writer().withRootName("root").writeValueAsString(message);
	}

}

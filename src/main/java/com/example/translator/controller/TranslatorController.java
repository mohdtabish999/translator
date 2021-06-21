package com.example.translator.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.translator.constant.TranslatorConstants;
import com.example.translator.service.TranslatorServiceJsonXml;
import com.example.translator.service.TranslatorServiceXmlJson;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/translate")
public class TranslatorController {
	
	private static final Logger LOG = LogManager.getLogger(TranslatorController.class);
	
	@Autowired
	TranslatorServiceXmlJson xmlToJsonService; 
	
	@Autowired
	TranslatorServiceJsonXml jsonToXmlService;

	/*
	 * @PostMapping("/sss") public String logoutPage(HttpServletRequest request) {
	 * UserInfo info =
	 * (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR); if (info !=
	 * null) { authService.userLogout(info.getUserName());
	 * request.getSession().setAttribute(USER_SESSION_ATTR, null); } return "index";
	 * }
	 */

	@PostMapping(path = "/data")
	public String save(
			@RequestHeader(name = "inputType", required = true) String inputType,
			@RequestHeader(name = "outputType", required= true) String outputType,
			@RequestBody Object message) throws JsonProcessingException {
	 
		String outputMessage = null;
		
		if (TranslatorConstants.XML_VALUE.equalsIgnoreCase(inputType) && TranslatorConstants.JSON_VALUE.equalsIgnoreCase(outputType)){
			outputMessage = xmlToJsonService.transform(message);
			LOG.log(Level.INFO, "/translating xml to json - &gt; " );
			System.out.println("xml to json");
			LOG.log(Level.INFO, "/xml data - &gt; " + message);
			LOG.log(Level.INFO, "/json data - &gt; " + outputMessage);
			
		} else if (TranslatorConstants.JSON_VALUE.equalsIgnoreCase(inputType) && TranslatorConstants.XML_VALUE.equalsIgnoreCase(outputType)){
			outputMessage = jsonToXmlService.transform(message);
			System.out.println("json to xml");
			LOG.log(Level.INFO, "/translating json to  xml - &gt; " );
			LOG.log(Level.INFO, "/json data - &gt; " + message);
			LOG.log(Level.INFO, "/xml data - &gt; " + outputMessage);
		}
		return outputMessage;
	}

	@GetMapping("/hello")
	public String test() {
		LOG.log(Level.INFO, "/hello service call - &gt;");
		return "hello";
	}
	 
}

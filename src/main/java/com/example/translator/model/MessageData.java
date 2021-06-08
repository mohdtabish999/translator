package com.example.translator.model;

public class MessageData {
	
	String id;
	
	String message;
	
	String sourceLanguage;
	
	String targetLanguage;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetlanguage) {
		this.targetLanguage = targetlanguage;
	}

}

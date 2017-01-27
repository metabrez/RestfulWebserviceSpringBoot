package com.restfulwebservicespringBoot.util;

import java.util.HashMap;
import java.util.Map;

public class ServiceResponse {
	private Boolean success;
	private String message;
	private Map<String, Object> params;

	
	public ServiceResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
		this.params = new HashMap<String, Object>();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void addParam(String key, Object value) {
		params.put(key, value);
	}

}

package com.umutcanbolat.instantusernamesearchapi.Model;

public class ServiceResponseModel {
	private String service;
	private String url;
	private boolean available;
	private String message;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ServiceResponseModel [service=" + service + ", url=" + url + ", available=" + available + ", message="
				+ message + "]";
	}

	public ServiceResponseModel(String service, String url, boolean available) {
		super();
		this.service = service;
		this.url = url;
		this.available = available;
	}

	public ServiceResponseModel(String message) {
		super();
		this.message = message;
	}

}

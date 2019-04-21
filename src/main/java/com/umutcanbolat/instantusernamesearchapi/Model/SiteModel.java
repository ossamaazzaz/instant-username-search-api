package com.umutcanbolat.instantusernamesearchapi.Model;

public class SiteModel {
	private String service;
	private String url;
	private String urlRegister;
	private int errorType;
	private String errorMsg;

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

	public String getUrlRegister() {
		return urlRegister;
	}

	public void setUrlRegister(String urlRegister) {
		this.urlRegister = urlRegister;
	}

	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public SiteModel(String service, String url, String urlRegister, int errorType, String errorMsg) {
		super();
		this.service = service;
		this.url = url;
		this.urlRegister = urlRegister;
		this.errorType = errorType;
		this.errorMsg = errorMsg;
	}
}

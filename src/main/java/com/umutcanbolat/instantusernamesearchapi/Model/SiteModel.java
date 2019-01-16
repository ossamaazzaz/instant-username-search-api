package com.umutcanbolat.instantusernamesearchapi.Model;

public class SiteModel {
	private String service;
	private String url;
	private String urlMain;

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

	public String getUrlMain() {
		return urlMain;
	}

	public void setUrlMain(String urlMain) {
		this.urlMain = urlMain;
	}

	@Override
	public String toString() {
		return "SitesModel [service=" + service + ", url=" + url + ", urlMain=" + urlMain + "]";
	}

	public SiteModel(String service, String url, String urlMain) {
		super();
		this.service = service;
		this.url = url;
		this.urlMain = urlMain;
	}

}

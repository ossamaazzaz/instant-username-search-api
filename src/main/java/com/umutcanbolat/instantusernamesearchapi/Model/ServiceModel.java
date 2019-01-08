package com.umutcanbolat.instantusernamesearchapi.Model;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceModel {
	private String service;
	private String endpoint;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@Override
	public String toString() {
		return "ServiceModel [service=" + service + ", endpoint=" + endpoint + "]";
	}

	@Autowired
	public ServiceModel(String service, String endpoint) {
		super();
		this.service = service;
		this.endpoint = endpoint;
	}

}

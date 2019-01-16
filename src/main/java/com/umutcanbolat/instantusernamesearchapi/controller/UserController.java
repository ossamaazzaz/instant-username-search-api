package com.umutcanbolat.instantusernamesearchapi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.umutcanbolat.instantusernamesearchapi.Model.ServiceModel;
import com.umutcanbolat.instantusernamesearchapi.Model.ServiceResponseModel;
import com.umutcanbolat.instantusernamesearchapi.Model.SiteModel;

@RestController
public class UserController {

	@RequestMapping("/check/{service}/{username}")
	public ServiceResponseModel searchUsername(@PathVariable String service, @PathVariable String username)
			throws FileNotFoundException, UnirestException {
		try {
			// read sites data from resources
			ClassLoader classLoader = getClass().getClassLoader();
			File sitesFile = new File(classLoader.getResource("static/sites.json").getFile());

			// parse json to model list
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(sitesFile));
			Type listType = new TypeToken<ArrayList<SiteModel>>() {
			}.getType();
			List<SiteModel> sitesList = gson.fromJson(reader, listType);

			for (SiteModel site : sitesList) {
				if (site.getService().toLowerCase().equals(service.toLowerCase())) {
					String url = site.getUrl().replace("{}", username);
					HttpResponse<String> response = Unirest.get(url).header("Connection", "keep-alive")
							.header("Upgrade-Insecure-Requests", "1")
							.header("User-Agent",
									"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
							.header("Accept",
									"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
							.header("Accept-Encoding", "gzip, deflate").header("Accept-Language", "en-US;q=1")
							.asString();
					boolean available = false;
					if (response.getStatus() != 200) {
						available = true;
					}
					return new ServiceResponseModel(url, available);
				}
			}
			// service not found
			return new ServiceResponseModel("Service: " + service + " is not supported");
		} catch (Exception ex) {
			return new ServiceResponseModel(ex.getStackTrace().toString());
		}
	}

	@RequestMapping("/services/getAll")
	public List<ServiceModel> getServicesList() {
		// read sites data from resources
		ClassLoader classLoader = getClass().getClassLoader();
		File sitesFile = new File(classLoader.getResource("static/sites.json").getFile());

		List<ServiceModel> serviceList = new ArrayList<ServiceModel>();

		try {
			// parse json
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(sitesFile));
			JsonElement jelement = new JsonParser().parse(reader);
			JsonObject obj = jelement.getAsJsonObject();

			Set<Map.Entry<String, JsonElement>> sites = obj.entrySet();

			for (Map.Entry<String, JsonElement> site : sites) {
				serviceList.add(new ServiceModel(site.getKey(), "/" + site.getKey().toLowerCase() + "/{username}"));
			}
			return serviceList;
		} catch (Exception ex) {
			return null;
		}

	}
}

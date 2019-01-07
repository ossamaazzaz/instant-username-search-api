package com.umutcanbolat.instantusernamesearchapi.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class UserController {

	@RequestMapping("/username/{username}")
	public String searchUsername(@PathVariable String username) throws FileNotFoundException, UnirestException {
		ClassLoader classLoader = getClass().getClassLoader();
		File sitesFile = new File(classLoader.getResource("static/sites.json").getFile());

		System.out.println(sitesFile.getAbsolutePath());

		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(sitesFile));
		JsonElement jelement = new JsonParser().parse(reader);
		JsonObject obj = jelement.getAsJsonObject();

		Set<Map.Entry<String, JsonElement>> sites = obj.entrySet();

		for (Map.Entry<String, JsonElement> site : sites) {

			JsonObject siteDetail = site.getValue().getAsJsonObject();
			Set<Map.Entry<String, JsonElement>> details = siteDetail.entrySet();
			Map.Entry<String, JsonElement> address = details.iterator().next();
			String url = address.getValue().toString().replace("{}", username);

			System.out.println(url);

			// TODO: Fix java.net.MalformedURLException: no protocol execption
			HttpResponse<String> response = Unirest.get(url).header("Connection", "keep-alive")
					.header("Upgrade-Insecure-Requests", "1")
					.header("User-Agent",
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
					.header("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
					.header("Accept-Encoding", "gzip, deflate").header("Accept-Language", "en-US;q=1").asString();

			response.getStatus();

			// System.out.println(site.getKey() + ": " + site.getValue());
			System.out.println(url + ": " + response.getStatus());

		}

		return "asd";
	}

}

package com.umutcanbolat.instantusernamesearchapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachingController {
	@Autowired
	CacheManager cacheManager;
	
    public void clearAllCaches() {
    	cacheManager.getCacheNames().stream()
        .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
    
    @Scheduled(fixedRate = 10800000)
    public void evictAllcachesAtIntervals() {
    	// clears cache in every 3 hours
    	clearAllCaches();
    }
}

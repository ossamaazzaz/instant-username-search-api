package com.umutcanbolat.instantusernamesearchapi.controller;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;
import com.umutcanbolat.instantusernamesearchapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
  @Autowired SearchService searchService;

  @PostMapping("/initSearch")
  public void initSearch(SearchModel search) {
    searchService.addSearch(search);
  }
}

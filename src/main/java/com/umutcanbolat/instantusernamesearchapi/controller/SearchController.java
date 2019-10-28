package com.umutcanbolat.instantusernamesearchapi.controller;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchCountResponseModel;
import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;
import com.umutcanbolat.instantusernamesearchapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
  @Autowired SearchService searchService;

  @PostMapping("/initSearch")
  public void initSearch(SearchModel search) {
    searchService.addSearch(search);
  }

  /**
   * Gets the total count of searches made until now.
   *
   * @return count.
   */
  @GetMapping("/getTotalCount")
  public SearchCountResponseModel getLastWeek(SearchModel search) {
    return searchService.getTotalCount();
  }
}

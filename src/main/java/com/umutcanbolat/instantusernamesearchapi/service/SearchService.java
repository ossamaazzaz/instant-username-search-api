package com.umutcanbolat.instantusernamesearchapi.service;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchCountResponseModel;
import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;

public interface SearchService {
  void addSearch(SearchModel search);

  SearchCountResponseModel getTotalCount();
}

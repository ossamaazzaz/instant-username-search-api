package com.umutcanbolat.instantusernamesearchapi.service;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchCountResponseModel;
import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;
import com.umutcanbolat.instantusernamesearchapi.dao.SearchDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class SearchServiceImpl implements SearchService {
  @Autowired SearchDAO searchDAO;

  @Override
  public void addSearch(SearchModel search) {
    // set current time
    search.setDate(new Date().getTime() / 1000);
    searchDAO.save(search);
  }

  @Override
  public SearchCountResponseModel getTotalCount() {
    SearchCountResponseModel res = new SearchCountResponseModel();
    res.setCount(searchDAO.count());

    return res;
  }
}

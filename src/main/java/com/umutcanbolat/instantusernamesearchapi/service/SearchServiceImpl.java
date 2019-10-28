package com.umutcanbolat.instantusernamesearchapi.service;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;
import com.umutcanbolat.instantusernamesearchapi.dao.SearchDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

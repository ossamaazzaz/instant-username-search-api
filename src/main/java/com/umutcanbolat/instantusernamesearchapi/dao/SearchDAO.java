package com.umutcanbolat.instantusernamesearchapi.dao;

import com.umutcanbolat.instantusernamesearchapi.Model.SearchModel;
import org.springframework.data.repository.CrudRepository;

public interface SearchDAO extends CrudRepository<SearchModel, Integer> {}

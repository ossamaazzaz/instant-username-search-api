package com.umutcanbolat.instantusernamesearchapi.Model;

public class SearchCountResponseModel {
  private long count;

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "SearchCountResponseModel{" + "count=" + count + '}';
  }
}

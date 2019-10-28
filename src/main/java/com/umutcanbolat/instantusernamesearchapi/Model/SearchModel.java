package com.umutcanbolat.instantusernamesearchapi.Model;

import javax.persistence.*;

@Entity
public class SearchModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "serial")
  private int id;

  private long date;
  private String username;
  private String userAgent;
  private String language;
  private String client;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "SearchModel{"
        + "id="
        + id
        + ", date="
        + date
        + ", username='"
        + username
        + '\''
        + ", userAgent='"
        + userAgent
        + '\''
        + ", language='"
        + language
        + '\''
        + ", client='"
        + client
        + '\''
        + '}';
  }
}

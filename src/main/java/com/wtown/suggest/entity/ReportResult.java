package com.wtown.suggest.entity;


public class ReportResult {

  private long id;
  private String description;
  private String images;
  private String createTime;
  private long isView;
  private long isDeal;
  private String dealSuggest;
  private String dealTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public long getIsView() {
    return isView;
  }

  public void setIsView(long isView) {
    this.isView = isView;
  }


  public long getIsDeal() {
    return isDeal;
  }

  public void setIsDeal(long isDeal) {
    this.isDeal = isDeal;
  }


  public String getDealSuggest() {
    return dealSuggest;
  }

  public void setDealSuggest(String dealSuggest) {
    this.dealSuggest = dealSuggest;
  }


  public String getDealTime() {
    return dealTime;
  }

  public void setDealTime(String dealTime) {
    this.dealTime = dealTime;
  }

}

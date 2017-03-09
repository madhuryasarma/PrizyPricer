package com.agreeya.springpoc.dtos;

import com.agreeya.springpoc.entities.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductDto {

  private Long id;
  private String name;
  private String barcode;
  private Double avgPrice;
  private Double highPrice;
  private Double lowPrice;
  private Double idealPrice;
  private String description;
  private Double price;
  private String notes;
  private Long storeId;
  private String store;
  
  public ProductDto() {
  }

  public ProductDto(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.barcode = product.getBarcode();
    this.description = product.getDescription();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public Double getAvgPrice() {
    return avgPrice;
  }

  public void setAvgPrice(Double avgPrice) {
    this.avgPrice = avgPrice;
  }

  public Double getHighPrice() {
    return highPrice;
  }

  public void setHighPrice(Double highPrice) {
    this.highPrice = highPrice;
  }

  public Double getLowPrice() {
    return lowPrice;
  }

  public void setLowPrice(Double lowPrice) {
    this.lowPrice = lowPrice;
  }

  public Double getIdealPrice() {
    return idealPrice;
  }

  public void setIdealPrice(Double idealPrice) {
    this.idealPrice = idealPrice;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

}

package com.agreeya.springpoc.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "product" )
public class Product {

  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;
  private String name;
  @Column(nullable = false, unique = true)
  private String barcode;
  private String description;
  @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL, targetEntity = StoreItem.class)
  private List<StoreItem> stores;
  
  public Product() {
    
  }
  public Product(String name, String description) {
    super();
    this.name = name;
    this.barcode = UUID.randomUUID().toString();
    this.description = description;
  }
  public long getId() {
    return id;
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
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public List<StoreItem> getStores() {
    return stores;
  }
  public void setStores(List<StoreItem> stores) {
    this.stores = stores;
  }
  
}

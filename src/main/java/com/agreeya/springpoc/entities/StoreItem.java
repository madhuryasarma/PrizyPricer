package com.agreeya.springpoc.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "store_item" )
public class StoreItem {

  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;
  @Column(nullable = false, unique = true)
  private String store;
  @ManyToMany
  @JoinTable(name = "store_item_products",
      joinColumns = {@JoinColumn(name = "store_id", table = "product")},
      inverseJoinColumns = {@JoinColumn(name = "product_id", table = "store_item")})
  private List<Product> products;
  
  public StoreItem() {
  }
  
  public StoreItem(String store) {
    this.store = store;
  }

  public long getId() {
    return id;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

}

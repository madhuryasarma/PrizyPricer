package com.agreeya.springpoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "store_item_products" )
public class StoreProducts implements Serializable {

  private static final long serialVersionUID = -4083255304331709781L;
  /*@Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")*/
  //private long id;
  @Id
  private long product_id;
  @Id
  private long store_id;
  @Column(nullable = false, columnDefinition = "double default 0.0")
  private double price;
  @Column(nullable = true)
  private String notes;

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }

  public long getStore_id() {
    return store_id;
  }

  public void setStore_id(long store_id) {
    this.store_id = store_id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}

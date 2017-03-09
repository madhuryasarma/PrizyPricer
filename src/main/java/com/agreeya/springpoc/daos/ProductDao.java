package com.agreeya.springpoc.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agreeya.springpoc.dtos.ProductDto;
import com.agreeya.springpoc.entities.Product;
import com.agreeya.springpoc.entities.StoreItem;
import com.agreeya.springpoc.entities.StoreProducts;

@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Product createSingleProduct(ProductDto productDto){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        StoreItem store = null;
        Product product = null;
        try{
          store = (StoreItem) session.createQuery("select o from StoreItem o where o.store=?0", StoreItem.class)
            .setParameter(0, productDto.getStore()).getSingleResult();
        } catch(NoResultException nre){
          store = new StoreItem(productDto.getStore());
          store.setProducts(new ArrayList<Product>());
        }
        try{
            product = (Product) session.createQuery("select o from Product o where o.name=?0", Product.class)
              .setParameter(0, productDto.getName()).getSingleResult();
          } catch(NoResultException nre){
            product = new Product(productDto.getName(), productDto.getDescription());
          }
        store.getProducts().add(product);
        session.save(store);
        session.save(product);
        StoreProducts storeProducts = (StoreProducts) session.createQuery("select o from "
            + "StoreProducts o where o.product_id=?0 and o.store_id=?1")
            .setParameter(0, product.getId()).setParameter(1, store.getId()).getSingleResult();
        storeProducts.setPrice(productDto.getPrice());
        storeProducts.setNotes(productDto.getNotes());
        session.save( storeProducts );
        session.getTransaction().commit();
        session.close();
        return product;
    }
    
    public List<Product> fetchAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("select o from Product o", Product.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return products;
    }
    
    public Product fetchById(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("select o from Product o where o.id=?0", Product.class)
            .setParameter(0, id).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return product;
    }
}

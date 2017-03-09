package com.agreeya.springpoc.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agreeya.springpoc.entities.StoreProducts;

@Repository
public class StoreProductsDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<StoreProducts> fetchAllStoresWithProduct(Long productId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<StoreProducts> storeProducts = session.createQuery("select o from StoreProducts o where o.product_id=?0", StoreProducts.class)
                .setParameter(0, productId).getResultList();
        session.getTransaction().commit();
        session.close();
        return storeProducts;
    }
}

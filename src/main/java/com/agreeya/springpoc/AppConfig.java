package com.agreeya.springpoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.agreeya.springpoc.daos.ProductDao;
import com.agreeya.springpoc.daos.StoreProductsDao;
import com.agreeya.springpoc.mgr.ProductManager;
import com.agreeya.springpoc.service.HealthService;
import com.agreeya.springpoc.service.ProductService;

@Configuration
@ImportResource("WEB-INF/applicationContext.xml")
public class AppConfig {

    @Bean
    public ProductDao getProductDao(){
      return new ProductDao();
    }
    
    @Bean
    public StoreProductsDao getStoreProductsDao(){
      return new StoreProductsDao();
    }
    
  @Bean
  public ProductManager getProductManager(){
    return new ProductManager();
  }
  
  @Bean
  public HealthService getHealthService(){
    return new HealthService();
  }
  
  @Bean
  public ProductService getProductService(ProductManager productMgr){
    return new ProductService(productMgr);
  }
  
}

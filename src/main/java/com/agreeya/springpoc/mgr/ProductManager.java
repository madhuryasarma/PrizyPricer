package com.agreeya.springpoc.mgr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.agreeya.springpoc.daos.ProductDao;
import com.agreeya.springpoc.daos.StoreProductsDao;
import com.agreeya.springpoc.dtos.ProductDto;
import com.agreeya.springpoc.entities.Product;
import com.agreeya.springpoc.entities.StoreProducts;

@Component
public class ProductManager {

  @Autowired
  private ProductDao productDao;
  
  @Autowired
  private StoreProductsDao storeProductsDao;

//  public void setSessionFactory(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//  }
  @PostConstruct
  public void init(){
    System.out.println("productmgr initialized");
  }
  
  @Transactional()
  public ProductDto createProduct(ProductDto productDto){
    System.out.println("creating a product!!");
    return new ProductDto(productDao.createSingleProduct(productDto));
  }
  
  @Transactional(readOnly = true)
  public List<ProductDto> getAllProducts(){
    List<ProductDto> resultList = new ArrayList<ProductDto>();
    List<Product> entities = productDao.fetchAll();
    if(entities!=null && !entities.isEmpty()){
        for(Product product : entities){
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            resultList.add(dto);
          }
    }    
    return resultList;
  }
  
  @Transactional(readOnly = true)
  public ProductDto getProductById(Long id){
    Product entity = productDao.fetchById(id);
    ProductDto dto = new ProductDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
    dto.setBarcode(entity.getBarcode());
    
    List<StoreProducts> storeProducts = storeProductsDao.fetchAllStoresWithProduct(dto.getId());
    storeProducts.sort(new Comparator<StoreProducts>() {

        @Override
        public int compare(StoreProducts o1, StoreProducts o2) {
          if(o1.getPrice() < o2.getPrice())
            return -1;
          else if (o1.getPrice() > o2.getPrice())
            return 1;
          else
            return 0;
        }});
      
      double sum = 0, ideal = 0, low = storeProducts.get(0).getPrice(),
          high = storeProducts.get(storeProducts.size()-1).getPrice();
      for(int i=0; i<storeProducts.size(); i++){
        if(i>1 && i<storeProducts.size()-2)
          ideal += storeProducts.get(i).getPrice();
        sum += storeProducts.get(i).getPrice();
        high = high > storeProducts.get(i).getPrice() ? high : storeProducts.get(i).getPrice();
        low = low < storeProducts.get(i).getPrice() ? low : storeProducts.get(i).getPrice();
      }
    dto.setAvgPrice(storeProducts.size() > 0 ? sum/storeProducts.size() : 0);
    dto.setHighPrice(high);
    dto.setLowPrice(low);
    dto.setIdealPrice(ideal > 0 ? ideal/(storeProducts.size()-4) : 0);
    return dto;
  }
}

package com.agreeya.springpoc.service;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.agreeya.springpoc.dtos.ProductDto;
import com.agreeya.springpoc.mgr.ProductManager;

@RestController
public class ProductService {
  ProductManager productMgr;

  public ProductService(ProductManager productMgr) {
    this.productMgr = productMgr;
  }

  @RequestMapping(method = RequestMethod.POST, path = "product", consumes = "application/json",
      produces = "application/json")
  public @ResponseBody ProductDto createProduct(@RequestBody ProductDto product) {

    return productMgr.createProduct(product);
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "product/{product-id}", produces = "application/json")
      public @ResponseBody ProductDto getProduct(@PathVariable(value = "product-id") Long productId) {
        return productMgr.getProductById(productId);
      }
  
  @RequestMapping(method = RequestMethod.GET, path = "products", produces = "application/json")
  public @ResponseBody List<ProductDto> getProducts() {
    return productMgr.getAllProducts();
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "productEntry")
  public ModelAndView enterProduct() {
    return new ModelAndView("enterProduct.jsp");
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "listProducts")
  public ModelAndView listProducts() {
    return new ModelAndView("productList.jsp");
  }
  
  @RequestMapping(method = RequestMethod.GET, path = "viewProduct")
  public ModelAndView viewProduct(@RequestParam(name = "id") Long id, ModelMap map) {
    map.addAttribute("product", productMgr.getProductById(id));
    return new ModelAndView("productViewer.jsp");
  }
}

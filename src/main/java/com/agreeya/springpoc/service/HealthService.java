/**
 * 
 */
package com.agreeya.springpoc.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Madhurya
 *
 */
@Controller
public class HealthService {

//  @Autowired
//  AppProperties props;
  
  @RequestMapping(method = RequestMethod.GET, path="/health", produces="text/plain")
  public @ResponseBody String home() throws ClassNotFoundException {
//    Class.forName("com.amazon.redshift.jdbc42.Driver");
    return "Hello";
  }
}

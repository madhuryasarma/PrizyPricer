package com.agreeya.springpoc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration("test-servlet-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void aCreateProduct() throws Exception {
      this.mockMvc.perform(post("/product")
          .content("{\"name\":\"Madhurya1\",\"description\":\"fgbnfgn\",\"price\":78,\"notes\":\"djfnvkjdfnjvd\",\"store\":\"Sample Stores\"}")
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
  @Test()
  public void bGetAllProducts() throws Exception {
      this.mockMvc.perform(get("/products").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
  @Test
  public void cgetProduct() throws Exception {
      this.mockMvc.perform(get("/product/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"));
  }
}

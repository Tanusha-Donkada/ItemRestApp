package com.itemrestapp.itemrestapp;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Item;

@SpringBootTest
class ItemrestappApplicationTests {

	/*@Test
    void test1() throws URISyntaxException, JsonProcessingException {     
      
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8008/findbyid/1";
      URI uri=new URI(url);
      
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
      
  }*/
	@Autowired
	ItemDao itemdao;
	@Test
	void testAddItem() {
		Item i=new Item();
		i.setItemName("sugar");
		i.setPrice(300.0f);
		i.setQuantity(12);
		itemdao.save(i);
		Item item=itemdao.findById(i.getItemId()).get();
	    Assertions.assertEquals(i.getItemName(),item.getItemName());
	}

}

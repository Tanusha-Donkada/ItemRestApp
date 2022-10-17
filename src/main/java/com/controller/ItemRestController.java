package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDao;
import com.model.Item;

@RestController
public class ItemRestController {
	@Autowired 
	ItemDao dao;
	
	@GetMapping("/homeinfo")
	public String getHomeInfo() {
		return "ItemRestController!Your API is working fine";
	}
	
	@PostMapping("/additem")
	public ResponseEntity addItem(@RequestBody Item item) {
		dao.save(item);
		return new ResponseEntity("Item added",HttpStatus.OK);
	}
	@GetMapping("/getallitems")
	public List<Item> getAllItems(){
		return dao.findAll();
	}
	//List<Item> itemlist=new ArrayList<>();
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item item) {
		dao.save(item);
		return new ResponseEntity("Item updated",HttpStatus.OK);
		/*for(int i=0;i<itemlist.size();i++) {
			if(itemlist.get(i).getItemId()==item.getItemId())
		}*/
	}
	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteItem(@RequestBody Item item) {
		dao.delete(item);
		return new ResponseEntity("Item deleted",HttpStatus.OK);
	}
	@GetMapping("findbyid/{id}")
	public Item getByItem(@PathVariable int id) {
		Item item=dao.findById(id).get();
		return item;
	}
}

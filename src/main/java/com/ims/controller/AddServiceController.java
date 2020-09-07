package com.ims.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.entity.AddService;
import com.ims.repository.AddServiceRepository;


@RestController
public class AddServiceController {
	
	@Autowired
	
	AddServiceRepository repo;
	
	//http://localhost:4545/fetchall
	@GetMapping("/fetchall")
	public ResponseEntity<List<AddService>> getAllItems(){
		
		List<AddService> list=repo.findAll();
		return new ResponseEntity<List<AddService>>(list,HttpStatus.OK);
	}

	//http://localhost:4545/fetchall/2
	@GetMapping("/fetchall/{itemid}")
	
	public ResponseEntity<Optional<AddService>> getitemById(@PathVariable ("itemid") Integer item_Id){
		
		Optional<AddService> opt=repo.findById(item_Id);
		return new ResponseEntity<Optional<AddService>>(opt,HttpStatus.OK);
		
	}
	
	//http://localhost:4545/fetchall/create
	@PostMapping("/fetchall/create")
	 public String addItem(@RequestBody AddService service) {
		
		boolean flag=repo.existsById(service.getItem_Id());
		
		if(flag==true) {
			
			return "Item is already exits";
		}
		
		else {
		
		 repo.save(service);
		 
		 return "Item added to database";
		
		}
	}
		
	//http://localhost:4545/fetchall/update
	@PutMapping("fetchall/update")
	
	public String updateItem(@RequestBody AddService service) {
		
		boolean flag =repo.existsById(service.getItem_Id());
		if(flag==true) {
			
			repo.saveAndFlush(service);
			
			return "The item is updated";
			
		}
		
		else {
		
		return "Iem Id Doest not exit";
		
		}
			}
	
	@DeleteMapping("fetchall/delete")
	public String  deleteItem(@RequestParam ("item") Integer itemid) {
		
		boolean flag=repo.existsById(itemid);
		
		if(flag==true) {
			repo.deleteById(itemid);
			
			return  "The Item is  deleted.";
			
		}
		
		else {
		
		return "Sorry, The item doesn't  exist";
		}
		
	}
		
		
		
	
	

}

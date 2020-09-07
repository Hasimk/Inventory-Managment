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

import com.ims.entity.AddCategory;
import com.ims.repository.AddCategoryRepository;

@RestController
public class AddCategoryController {

	@Autowired

	AddCategoryRepository repo;

//http://localhost:4545/allitems
	@GetMapping("/allitems")
	public ResponseEntity<List<AddCategory>> getallItem() {

		List<AddCategory> list = repo.findAll();

		return new ResponseEntity<List<AddCategory>>(list, HttpStatus.OK);

	}

//http://localhost:4545/allitems/2
	@GetMapping("/allitems/{id}")
	public ResponseEntity<Optional<AddCategory>> getitemById(@PathVariable("id") Integer id) {

		Optional<AddCategory> opt = repo.findById(id);

		return new ResponseEntity<Optional<AddCategory>>(opt, HttpStatus.OK);

	}

	// http://localhost:4545//allitems/create
	@PostMapping("/allitems/create")
	public String storItem(@RequestBody AddCategory addCategory) {

		boolean flag = repo.existsById(addCategory.getC_Id());

		if (flag == true) {

			return "Item already exists";

		} else {

			repo.save(addCategory);

			return "Item added to database";
		}

	}

	//http://localhost:4545//allitems/update
	@PutMapping("/allitems/update")

	public String updateItem(@RequestBody AddCategory addCategory) {

		boolean flag = repo.existsById(addCategory.getC_Id());

		if (flag == true) {
			repo.saveAndFlush(addCategory);

			return "The Item is updated";
		}

		else {

			return "Item Id doent not exits";

		}

	}

	@DeleteMapping("/allitems/delete")
	
	public String deleteItem(@RequestParam ("Cid") Integer cid) {
		
		boolean flag= repo.existsById(cid);
		if(flag==true) {
			
			repo.deleteById(cid);
			
			return "The Item is  deleted.";
		}
		
		else {
			
			return "Sorry, The item doesn't  exist";
		}
		
		
	}
	
}

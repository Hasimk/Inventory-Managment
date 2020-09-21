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

import com.ims.entity.Product_List;
import com.ims.repository.ProductListRepository;


@RestController
public class ProductListRestcontroller {

    @Autowired

    private ProductListRepository repo;

    // http://localhost:4545/allproduct
    @GetMapping("/allproduct")
    public ResponseEntity<List<Product_List>> getallitems() {

        List<Product_List> list = repo.findAll();

        return new ResponseEntity<List<Product_List>>(list, HttpStatus.OK);

    }
    //http://localhost:4545/allproduct/2

    @GetMapping("/allproduct/{pid}")

    public ResponseEntity<Optional<Product_List>> findByProductId(@PathVariable("pid") Integer pid) {

        Optional<Product_List> opt = repo.findById(pid);

        return new ResponseEntity<Optional<Product_List>>(opt, HttpStatus.OK);

    }

    //http://localhost:4545/allproduct/create
    @PostMapping("/allproduct/create")
    
    public String creatProduct(@RequestBody Product_List productlist) {
        
        boolean flag=repo.existsById(productlist.getP_Id());
        if(flag==true) {
            
            return "product already exists";
            
            
        }
        
        else {
        
            repo.save(productlist);
            
        return "product added to database";
        }
        
    }
    
    //http://localhost:4545/allproduct/update
    @PutMapping("/allproduct/update")
    
    public String productUpdate(@RequestBody Product_List product_List) {
        
        boolean flag=repo.existsById(product_List.getP_Id());
        
        if(flag==true) {
            
            repo.saveAndFlush(product_List);
            
            return " The product is updated";

        }

        else {

            return "Product Id doent not exits";

        
        
        
    }
    }
    
    //http://localhost:4545/allproduct/delete?Pid=9
    @DeleteMapping("/allproduct/delete")
    
    public String deleteProduct(@RequestParam("Pid") Integer pid) {
        boolean flag = repo.existsById(pid);
        if (flag == true) {
            repo.deleteById(pid);
            return "The product is  deleted.";

        } else {
            return "Sorry, The product doesn't  exist";
        }
    }

        
        
    
}


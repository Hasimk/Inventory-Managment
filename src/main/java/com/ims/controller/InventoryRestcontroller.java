
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
import com.ims.entity.Inventory;
import com.ims.repository.InventoryRepository;


@RestController
public class InventoryRestcontroller {

    @Autowired
    InventoryRepository repo;

    // http://localhost:4545/Allitems
    @GetMapping("/Allitems")
    public ResponseEntity<List<Inventory>> getAllitems() {

        List<Inventory> ilist = repo.findAll();

        return new ResponseEntity<List<Inventory>>(ilist, HttpStatus.OK);

    }

    // http://localhost:4545/Allitems/3
    @GetMapping("/Allitems/{inventoryid}")
    public ResponseEntity<Optional<Inventory>> getItemById(@PathVariable("inventoryid") Integer inventoryid) {
        Optional<Inventory> opt = repo.findById(inventoryid);
        return new ResponseEntity<Optional<Inventory>>(opt, HttpStatus.OK);

    }

    // http://localhost:4545/Allitems/create
    @PostMapping("/Allitems/create")
    public String storeinventory(@RequestBody Inventory inventory)

    {
        boolean flag = repo.existsById(inventory.getInventoryid());
        if (flag == true) {
            return "Item already exists";

        } else {
            repo.save(inventory);
            return "Item added to database";
        }
    }

    // http://localhost:4545/Allitems/update
    @PutMapping("/Allitems/update")
    public String updateInventory(@RequestBody Inventory inv) {

        boolean flag = repo.existsById(inv.getInventoryid());

        if (flag == true) {

            repo.saveAndFlush(inv);

            return " The inventory is updated";

        }

        else {

            return "Inventoy Id doent not exits";

        }

    }

    // http://localhost:4545/Allitems/delete?Inventoryid=2

    @DeleteMapping("/Allitems/delete")
    public String deleteInventory(@RequestParam("Inventoryid") Integer inventoryId) {

        boolean flag = repo.existsById(inventoryId);
        if (flag == true) {
            repo.deleteById(inventoryId);
            return "The Item is  deleted.";

        } else {
            return "Sorry, The item doesn't  exist";
        }
    }

}

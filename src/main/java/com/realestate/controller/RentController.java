package com.realestate.controller;

import com.realestate.entities.Rent;
import com.realestate.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    public ResponseEntity<List<Rent>> getAllRents() {
        List<Rent> rents = rentService.getAllRents();
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        Rent rent = rentService.getRentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        Rent createdRent = rentService.saveRent(rent);
        return new ResponseEntity<>(createdRent, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRent(@PathVariable Long id) {
        Rent rent = rentService.getRentById(id);
        return new ResponseEntity<>("Rent Deleted successfully",HttpStatus.OK);
    }
}

//@PutMapping("/{id}")
//    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent updatedRent) {
//        Rent rent = rentService.getRentById(id);
//        if (rent != null) {
//            updatedRent.setRentId(id);
//            Rent updated = rentService.saveRent(updatedRent);
//            return new ResponseEntity<>(updated, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

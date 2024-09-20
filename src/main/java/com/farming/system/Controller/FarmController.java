package com.farming.system.Controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import com.farming.system.Model.FarmModel;
	import com.farming.system.Service.FarmService; // Corrected package name

	import java.util.List;

	@RestController
	@RequestMapping("/farm")
	public class FarmController {

	    @Autowired
	    private FarmService farmservice;

	    @PostMapping("/add")
	    public ResponseEntity<FarmModel> save(@RequestBody FarmModel farm) {
	        return new ResponseEntity<>(farmservice.save(farm), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<FarmModel>> getAllFarm() {
	        return new ResponseEntity<>(farmservice.getAllFarm(), HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<FarmModel> update(@PathVariable Long id, @RequestBody FarmModel farm) {
	        try {
	            FarmModel updatedFarm = farmservice.update(id, farm);
	            return new ResponseEntity<>(updatedFarm, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        boolean isDeleted = farmservice.delete(id);
	        if (isDeleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}


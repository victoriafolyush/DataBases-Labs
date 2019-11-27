package com.vika.controllers;

import com.vika.models.Manufacturer;
import com.vika.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;


    @GetMapping("/manufacturer")
    public List<Manufacturer> findAll() throws Exception {
        return manufacturerService.findAll();
    }
    @GetMapping("/manufacturer/{id}")
    public Manufacturer findById(@PathVariable Integer id) throws Exception {
        return manufacturerService.findById(id);
    }

    @PostMapping("/manufacturer")
    public void create(@RequestBody Manufacturer entity) throws Exception {
        manufacturerService.create(entity);
    }

    @PutMapping("/manufacturer/{id}")
    public void update(@PathVariable Integer id, @RequestBody Manufacturer entity) throws Exception {
        entity.setId(id);
        manufacturerService.update(entity);
    }

    @DeleteMapping("/manufacturer/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        manufacturerService.delete(id);
    }
}
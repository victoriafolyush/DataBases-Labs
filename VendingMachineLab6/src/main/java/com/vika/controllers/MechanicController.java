package com.vika.controllers;

import com.vika.models.Manufacturer;
import com.vika.models.Mechanic;
import com.vika.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;


    @GetMapping("/mechanic")
    public List<Mechanic> findAll() throws Exception {
        return mechanicService.findAll();
    }
    @GetMapping("/mechanic/{id}")
    public Mechanic findById(@PathVariable Integer id) throws Exception {
        return mechanicService.findById(id);
    }

    @PostMapping("/mechanic")
    public void create(@RequestBody Mechanic entity) throws Exception {
        mechanicService.create(entity);
    }

    @PutMapping("/mechanic/{id}")
    public void update(@PathVariable Integer id, @RequestBody Mechanic entity) throws Exception {
        entity.setId(id);
        mechanicService.update(entity);
    }

    @DeleteMapping("/mechanic/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        mechanicService.delete(id);
    }
}
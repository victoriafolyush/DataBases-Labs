package com.vika.controllers;

import com.vika.models.Product;
import com.vika.models.VendingMachine;
import com.vika.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class VendingMachineController {

    @Autowired
    private VendingMachineService vendingMachineService;


    @GetMapping("/vending_machine")
    public List<VendingMachine> findAll() throws Exception {
        return vendingMachineService.findAll();
    }
    @GetMapping("/vending_machine/{id}")
    public VendingMachine findById(@PathVariable Integer id) throws Exception {
        return vendingMachineService.findById(id);
    }

    @PostMapping("/vending_machine")
    public void create(@RequestBody VendingMachine entity) throws Exception {
        vendingMachineService.create(entity);
    }

    @PutMapping("/vending_machine/{id}")
    public void update(@PathVariable Integer id, @RequestBody VendingMachine entity) throws Exception {
        entity.setId(id);
        vendingMachineService.update(entity);
    }

    @DeleteMapping("/vending_machine/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        vendingMachineService.delete(id);
    }
}
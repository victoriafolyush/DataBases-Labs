package com.vika.controllers;

import com.vika.models.VendingMachineHasMenu;
import com.vika.models.VendingMachineHasProduct;
import com.vika.service.VendingMachineHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class VendingMachineHasProductController {

    @Autowired
    private VendingMachineHasProductService vendingMachineHasProductService;


    @GetMapping("/vending_machine_has_product")
    public List<VendingMachineHasProduct> findAll() throws Exception {
        return vendingMachineHasProductService.findAll();
    }
    @GetMapping("/vending_machine_has_product/{id}")
    public VendingMachineHasProduct findById(@PathVariable Integer id) throws Exception {
        return vendingMachineHasProductService.findById(id);
    }

    @PostMapping("/vending_machine_has_product")
    public void create(@RequestBody VendingMachineHasProduct entity) throws Exception {
        vendingMachineHasProductService.create(entity);
    }

    @PutMapping("/vending_machine_has_product/{id}")
    public void update(@PathVariable Integer id, @RequestBody VendingMachineHasProduct entity) throws Exception {
        entity.setId(id);
        vendingMachineHasProductService.update(entity);
    }

    @DeleteMapping("/vending_machine_has_product/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        vendingMachineHasProductService.delete(id);
    }
}
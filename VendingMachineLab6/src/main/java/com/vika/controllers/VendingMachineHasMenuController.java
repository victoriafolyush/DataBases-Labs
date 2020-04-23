package com.vika.controllers;

import com.vika.models.VendingMachineHasMenu;
import com.vika.service.VendingMachineHasMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class VendingMachineHasMenuController {

    @Autowired
    private VendingMachineHasMenuService vendingMachineHasMenuService;


    @GetMapping("/vending_machine_has_menu")
    public List<VendingMachineHasMenu> findAll() throws Exception {
        return vendingMachineHasMenuService.findAll();
    }
    @GetMapping("/vending_machine_has_menu/{id}")
    public VendingMachineHasMenu findById(@PathVariable Integer id) throws Exception {
        return vendingMachineHasMenuService.findById(id);
    }

    @PostMapping("/vending_machine_has_menu")
    public void create(@RequestBody VendingMachineHasMenu entity) throws Exception {
        vendingMachineHasMenuService.create(entity);
    }

    @PutMapping("/vending_machine_has_menu/{id}")
    public void update(@PathVariable Integer id, @RequestBody VendingMachineHasMenu entity) throws Exception {
        entity.setId(id);
        vendingMachineHasMenuService.update(entity);
    }

    @DeleteMapping("/vending_machine_has_menu/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        vendingMachineHasMenuService.delete(id);
    }
}
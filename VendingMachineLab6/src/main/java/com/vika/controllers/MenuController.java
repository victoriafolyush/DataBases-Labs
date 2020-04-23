package com.vika.controllers;

import com.vika.models.Mechanic;
import com.vika.models.Menu;
import com.vika.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/menu")
    public List<Menu> findAll() throws Exception {
        return menuService.findAll();
    }
    @GetMapping("/menu/{id}")
    public Menu findById(@PathVariable Integer id) throws Exception {
        return menuService.findById(id);
    }

    @PostMapping("/menu")
    public void create(@RequestBody Menu entity) throws Exception {
        menuService.create(entity);
    }

    @PutMapping("/menu/{id}")
    public void update(@PathVariable Integer id, @RequestBody Menu entity) throws Exception {
        entity.setId(id);
        menuService.update(entity);
    }

    @DeleteMapping("/menu/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        menuService.delete(id);
    }
}
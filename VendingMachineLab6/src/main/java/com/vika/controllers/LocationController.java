package com.vika.controllers;

import com.vika.models.DailyReportHasProduct;
import com.vika.models.Location;
import com.vika.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class LocationController {

    @Autowired
    private LocationService locationService;


    @GetMapping("/location")
    public List<Location> findAll() throws Exception {
        return locationService.findAll();
    }
    @GetMapping("/location/{id}")
    public Location findById(@PathVariable Integer id) throws Exception {
        return locationService.findById(id);
    }

    @PostMapping("/location")
    public void create(@RequestBody Location entity) throws Exception {
        locationService.create(entity);
    }

    @PutMapping("/location/{id}")
    public void update(@PathVariable Integer id, @RequestBody Location entity) throws Exception {
        entity.setId(id);
        locationService.update(entity);
    }

    @DeleteMapping("/location/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        locationService.delete(id);
    }
}

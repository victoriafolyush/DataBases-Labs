package com.vika.controllers;

import com.vika.models.DailyReport;
import com.vika.models.DailyReportHasProduct;
import com.vika.service.DailyReportHasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class DailyReportHasProductController {

    @Autowired
    private DailyReportHasProductService dailyReportHasProductService;


    @GetMapping("/daily_report_has_product")
    public List<DailyReportHasProduct> findAll() throws Exception {
        return dailyReportHasProductService.findAll();
    }
    @GetMapping("/daily_report_has_product/{id}")
    public DailyReportHasProduct findById(@PathVariable Integer id) throws Exception {
        return dailyReportHasProductService.findById(id);
    }

    @PostMapping("/daily_report_has_product")
    public void create(@RequestBody DailyReportHasProduct entity) throws Exception {
        dailyReportHasProductService.create(entity);
    }

    @PutMapping("/daily_report_has_product/{id}")
    public void update(@PathVariable Integer id, @RequestBody DailyReportHasProduct entity) throws Exception {
        entity.setId(id);
        dailyReportHasProductService.update(entity);
    }

    @DeleteMapping("/daily_report_has_product/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        dailyReportHasProductService.delete(id);
    }
}

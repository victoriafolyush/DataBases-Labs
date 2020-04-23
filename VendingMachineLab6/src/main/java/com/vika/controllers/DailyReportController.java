package com.vika.controllers;


import com.vika.models.DailyReport;
import com.vika.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")

public class DailyReportController {

    @Autowired
    private DailyReportService dailyReportService;


    @GetMapping("/daily_report")
    public List<DailyReport> findAll() throws Exception {
        return dailyReportService.findAll();
    }
    @GetMapping("/daily_report/{id}")
    public DailyReport findById(@PathVariable Integer id) throws Exception {
        return dailyReportService.findById(id);
    }

    @PostMapping("/daily_report")
    public void create(@RequestBody DailyReport entity) throws Exception {
        dailyReportService.create(entity);
    }

    @PutMapping("/daily_report/{id}")
    public void update(@PathVariable Integer id, @RequestBody DailyReport entity) throws Exception {
        entity.setId(id);
        dailyReportService.update(entity);
    }

    @DeleteMapping("/daily_report/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        dailyReportService.delete(id);
    }
}

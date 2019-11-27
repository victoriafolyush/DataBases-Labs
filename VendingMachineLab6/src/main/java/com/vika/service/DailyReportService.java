package com.vika.service;


import com.vika.models.DailyReport;
import com.vika.repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;


@Service
public class DailyReportService {

    @Autowired
    DailyReportRepository dailyReportRepository;

    public List<DailyReport> findAll() throws Exception {
        List<DailyReport> reports = new LinkedList<>(dailyReportRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public DailyReport findById(Integer id) throws Exception {
        if (dailyReportRepository.findById(id).isPresent()) {
            return dailyReportRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(DailyReport entity) throws Exception {
        if (entity != null) {
            dailyReportRepository.save(entity);
        }
    }

    @Transactional
    public void update(DailyReport entity) throws Exception {
        dailyReportRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setTimeOfReport(entity.getTimeOfReport());
                    oldEntity.setCurrencyLoadedFrom(entity.getCurrencyLoadedFrom());
                    oldEntity.setQuantityProductLoadedFrom(entity.getQuantityProductLoadedFrom());
                    oldEntity.setQuantityProductLoadedTo(entity.getQuantityProductLoadedTo());
                    oldEntity.setMechanicId(entity.getMechanicId());
                    oldEntity.setVendingMachineId(entity.getVendingMachineId());
                    return dailyReportRepository.save(oldEntity);
                })
                .orElseGet(() -> dailyReportRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (dailyReportRepository.findById(id).isPresent()) {
            dailyReportRepository.deleteById(id);
        }
    }

}

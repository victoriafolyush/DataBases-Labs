package com.vika.service;

import com.vika.models.DailyReport;
import com.vika.models.DailyReportHasProduct;
import com.vika.repository.DailyReportHasProductRepository;
import com.vika.repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DailyReportHasProductService {
    @Autowired
    DailyReportHasProductRepository dailyReportHasProductRepository;

    public List<DailyReportHasProduct> findAll() throws Exception {
        List<DailyReportHasProduct> accounts = new LinkedList<>(dailyReportHasProductRepository.findAll());
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts;
    }

    public DailyReportHasProduct findById (Integer id) throws Exception {
        if (dailyReportHasProductRepository.findById(id).isPresent()) {
            return dailyReportHasProductRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(DailyReportHasProduct entity) throws Exception {
        if (entity != null) {
            dailyReportHasProductRepository.save(entity);
        }
    }

    @Transactional
    public void update(DailyReportHasProduct entity) throws Exception {
        dailyReportHasProductRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDailyReportId(entity.getDailyReportId());
                    oldEntity.setProductId(entity.getProductId());
                    oldEntity.setQuantityProduct(entity.getQuantityProduct());
                    return dailyReportHasProductRepository.save(oldEntity);
                })
                .orElseGet(() -> dailyReportHasProductRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (dailyReportHasProductRepository.findById(id).isPresent()) {
            dailyReportHasProductRepository.deleteById(id);
        }
    }

}

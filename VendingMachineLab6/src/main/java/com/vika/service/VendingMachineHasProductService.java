package com.vika.service;

import com.vika.models.Location;
import com.vika.models.VendingMachineHasProduct;
import com.vika.repository.VendingMachineHasProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class VendingMachineHasProductService {
    @Autowired
    VendingMachineHasProductRepository vendingMachineHasProductRepository;

    public List<VendingMachineHasProduct> findAll() throws Exception {
        List<VendingMachineHasProduct> reports = new LinkedList<>(vendingMachineHasProductRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public VendingMachineHasProduct findById(Integer id) throws Exception {
        if (vendingMachineHasProductRepository.findById(id).isPresent()) {
            return vendingMachineHasProductRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(VendingMachineHasProduct entity) throws Exception {
        if (entity != null) {
            vendingMachineHasProductRepository.save(entity);
        }
    }

    @Transactional
    public void update(VendingMachineHasProduct entity) throws Exception {
        vendingMachineHasProductRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setVendingMachineId(entity.getVendingMachineId());
                    oldEntity.setProductId(entity.getProductId());
                    oldEntity.setSoldTime(entity.getSoldTime());
                    return vendingMachineHasProductRepository.save(oldEntity);
                })
                .orElseGet(() -> vendingMachineHasProductRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (vendingMachineHasProductRepository.findById(id).isPresent()) {
            vendingMachineHasProductRepository.deleteById(id);
        }
    }



}

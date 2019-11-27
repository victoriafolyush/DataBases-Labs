package com.vika.service;

import com.vika.models.Location;
import com.vika.models.VendingMachine;
import com.vika.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class VendingMachineService {
    @Autowired
    VendingMachineRepository vendingMachineRepository;

    public List<VendingMachine> findAll() throws Exception {
        List<VendingMachine> reports = new LinkedList<>(vendingMachineRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public VendingMachine findById(Integer id) throws Exception {
        if (vendingMachineRepository.findById(id).isPresent()) {
            return vendingMachineRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(VendingMachine entity) throws Exception {
        if (entity != null) {
            vendingMachineRepository.save(entity);
        }
    }

    @Transactional
    public void update(VendingMachine entity) throws Exception {
        vendingMachineRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setModel(entity.getModel());
                    oldEntity.setLocationId(entity.getLocationId());
                    oldEntity.setIsEmpty(entity.getIsEmpty());
                    return vendingMachineRepository.save(oldEntity);
                })
                .orElseGet(() -> vendingMachineRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (vendingMachineRepository.findById(id).isPresent()) {
            vendingMachineRepository.deleteById(id);
        }
    }


}

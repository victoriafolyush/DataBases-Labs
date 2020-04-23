package com.vika.service;

import com.vika.models.Location;
import com.vika.models.VendingMachineHasMenu;
import com.vika.repository.VendingMachineHasMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class VendingMachineHasMenuService {
    @Autowired
    VendingMachineHasMenuRepository vendingMachineHasMenuRepository;

    public List<VendingMachineHasMenu> findAll() throws Exception {
        List<VendingMachineHasMenu> reports = new LinkedList<>(vendingMachineHasMenuRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public VendingMachineHasMenu findById(Integer id) throws Exception {
        if (vendingMachineHasMenuRepository.findById(id).isPresent()) {
            return vendingMachineHasMenuRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(VendingMachineHasMenu entity) throws Exception {
        if (entity != null) {
            vendingMachineHasMenuRepository.save(entity);
        }
    }

    @Transactional
    public void update(VendingMachineHasMenu entity) throws Exception {
        vendingMachineHasMenuRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setMenuId(entity.getMenuId());
                    oldEntity.setVendingMachineId(entity.getVendingMachineId());
                    return vendingMachineHasMenuRepository.save(oldEntity);
                })
                .orElseGet(() -> vendingMachineHasMenuRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (vendingMachineHasMenuRepository.findById(id).isPresent()) {
            vendingMachineHasMenuRepository.deleteById(id);
        }
    }

}

package com.vika.service;

import com.vika.models.Location;
import com.vika.models.Manufacturer;
import com.vika.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() throws Exception {
        List<Manufacturer> reports = new LinkedList<>(manufacturerRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public Manufacturer findById(Integer id) throws Exception {
        if (manufacturerRepository.findById(id).isPresent()) {
            return manufacturerRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Manufacturer entity) throws Exception {
        if (entity != null) {
            manufacturerRepository.save(entity);
        }
    }

    @Transactional
    public void update(Manufacturer entity) throws Exception {
        manufacturerRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setName(entity.getName());
                    oldEntity.setCountry(entity.getCountry());
                    return manufacturerRepository.save(oldEntity);
                })
                .orElseGet(() -> manufacturerRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (manufacturerRepository.findById(id).isPresent()) {
            manufacturerRepository.deleteById(id);
        }
    }

}

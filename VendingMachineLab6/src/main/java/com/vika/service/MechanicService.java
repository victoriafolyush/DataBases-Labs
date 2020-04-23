package com.vika.service;

import com.vika.models.Location;
import com.vika.models.Mechanic;
import com.vika.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class MechanicService {
    @Autowired
    MechanicRepository mechanicRepository;

    public List<Mechanic> findAll() throws Exception {
        List<Mechanic> reports = new LinkedList<>(mechanicRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public Mechanic findById(Integer id) throws Exception {
        if (mechanicRepository.findById(id).isPresent()) {
            return mechanicRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Mechanic entity) throws Exception {
        if (entity != null) {
            mechanicRepository.save(entity);
        }
    }

    @Transactional
    public void update(Mechanic entity) throws Exception {
        mechanicRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setFirstName(entity.getFirstName());
                    oldEntity.setLastName(entity.getLastName());
                    return mechanicRepository.save(oldEntity);
                })
                .orElseGet(() -> mechanicRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (mechanicRepository.findById(id).isPresent()) {
            mechanicRepository.deleteById(id);
        }
    }


}

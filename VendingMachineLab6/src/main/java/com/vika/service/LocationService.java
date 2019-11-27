package com.vika.service;

import com.vika.models.DailyReport;
import com.vika.models.Location;
import com.vika.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAll() throws Exception {
        List<Location> reports = new LinkedList<>(locationRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public Location findById(Integer id) throws Exception {
        if (locationRepository.findById(id).isPresent()) {
            return locationRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Location entity) throws Exception {
        if (entity != null) {
            locationRepository.save(entity);
        }
    }

    @Transactional
    public void update(Location entity) throws Exception {
        locationRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setCountry(entity.getCountry());
                    oldEntity.setCity(entity.getCity());
                    oldEntity.setStreet(entity.getStreet());
                    oldEntity.setNumber(entity.getNumber());
                    oldEntity.setxCoordinate(entity.getxCoordinate());
                    oldEntity.setyCoordinate(entity.getyCoordinate());
                    return locationRepository.save(oldEntity);
                })
                .orElseGet(() -> locationRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (locationRepository.findById(id).isPresent()) {
            locationRepository.deleteById(id);
        }
    }

}


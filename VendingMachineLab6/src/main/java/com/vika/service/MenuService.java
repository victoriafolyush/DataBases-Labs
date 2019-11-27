package com.vika.service;

import com.vika.models.Location;
import com.vika.models.Menu;
import com.vika.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> findAll() throws Exception {
        List<Menu> reports = new LinkedList<>(menuRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public Menu findById(Integer id) throws Exception {
        if (menuRepository.findById(id).isPresent()) {
            return menuRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Menu entity) throws Exception {
        if (entity != null) {
            menuRepository.save(entity);
        }
    }

    @Transactional
    public void update(Menu entity) throws Exception {
        menuRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDateOfCreation(entity.getDateOfCreation());
                    return menuRepository.save(oldEntity);
                })
                .orElseGet(() -> menuRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (menuRepository.findById(id).isPresent()) {
            menuRepository.deleteById(id);
        }
    }


}

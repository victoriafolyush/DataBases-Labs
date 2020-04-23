package com.vika.repository;

import com.vika.models.VendingMachineHasMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineHasMenuRepository extends JpaRepository<VendingMachineHasMenu, Integer> {
}

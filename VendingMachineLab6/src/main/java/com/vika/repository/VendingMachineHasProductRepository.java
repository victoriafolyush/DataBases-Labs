package com.vika.repository;

import com.vika.models.VendingMachineHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineHasProductRepository extends JpaRepository<VendingMachineHasProduct, Integer> {
}

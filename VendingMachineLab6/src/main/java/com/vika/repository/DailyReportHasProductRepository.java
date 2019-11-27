package com.vika.repository;

import com.vika.models.DailyReportHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyReportHasProductRepository extends JpaRepository<DailyReportHasProduct, Integer> {
}

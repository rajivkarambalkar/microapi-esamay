package com.esamay.repository;

import com.esamay.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, String> {
    List<TimeSheet> findByUserId(String userId);
}

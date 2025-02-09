package com.sd75.repository;

import com.sd75.entity.TraHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraHangRepository extends JpaRepository<TraHang, Integer> {
}
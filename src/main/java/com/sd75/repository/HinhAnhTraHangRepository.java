package com.sd75.repository;

import com.sd75.entity.HinhAnhTraHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhTraHangRepository extends JpaRepository<HinhAnhTraHang, Integer> {
}
package com.sd75.repository;

import com.sd75.entity.ChiTietDotKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDotKhuyenMaiRepository extends JpaRepository<ChiTietDotKhuyenMai, Integer> {
}
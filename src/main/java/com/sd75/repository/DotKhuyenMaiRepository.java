package com.sd75.repository;

import com.sd75.entity.DotKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotKhuyenMaiRepository extends JpaRepository<DotKhuyenMai, Integer> {
}
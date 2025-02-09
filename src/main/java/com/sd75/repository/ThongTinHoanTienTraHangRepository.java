package com.sd75.repository;

import com.sd75.entity.ThongTinHoanTienTraHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinHoanTienTraHangRepository extends JpaRepository<ThongTinHoanTienTraHang, Integer> {
}
package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietDotKhuyenMai;
import com.sd75.service.ChiTietDotKhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chi-tiet-dot-khuyen-mai")
@RequiredArgsConstructor
public class ChiTietDotKhuyenMaiController {
    private final ChiTietDotKhuyenMaiService chiTietDotKhuyenMaiService;

    @PostMapping
    ApiRes<ChiTietDotKhuyenMai> save(@RequestBody ChiTietDotKhuyenMai chiTietDotKhuyenMai) {
        return chiTietDotKhuyenMaiService.save(chiTietDotKhuyenMai);
    }

    @GetMapping
    ApiRes<List<ChiTietDotKhuyenMai>> findAll() {
        return chiTietDotKhuyenMaiService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<ChiTietDotKhuyenMai> findById(@PathVariable Integer id) {
        return chiTietDotKhuyenMaiService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return chiTietDotKhuyenMaiService.delete(id);
    }
}
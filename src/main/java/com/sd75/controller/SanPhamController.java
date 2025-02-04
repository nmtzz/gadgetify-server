package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.SanPham;
import com.sd75.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/san-pham")
@RequiredArgsConstructor
public class SanPhamController {
    private final SanPhamService sanPhamService;

    @PostMapping
    ApiRes<SanPham> save(@RequestBody SanPham sanPham) {
        return sanPhamService.save(sanPham);
    }

    @GetMapping
    ApiRes<List<SanPham>> findAll() {
        return sanPhamService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<SanPham> findById(@PathVariable Integer id) {
        return sanPhamService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return sanPhamService.delete(id);
    }
}
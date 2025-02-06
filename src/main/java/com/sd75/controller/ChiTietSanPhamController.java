package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietSanPham;
import com.sd75.service.ChiTietSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chi-tiet-san-pham")
@RequiredArgsConstructor
public class ChiTietSanPhamController {
    private final ChiTietSanPhamService chiTietSanPhamService;

    @PostMapping
    ApiRes<ChiTietSanPham> save(@RequestBody ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamService.save(chiTietSanPham);
    }

    @GetMapping
    ApiRes<List<ChiTietSanPham>> findAll() {
        return chiTietSanPhamService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<ChiTietSanPham> findById(@PathVariable Integer id) {
        return chiTietSanPhamService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return chiTietSanPhamService.delete(id);
    }
}
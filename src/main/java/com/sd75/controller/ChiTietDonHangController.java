package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietDonHang;
import com.sd75.service.ChiTietDonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chi-tiet-don-hang")
@RequiredArgsConstructor
public class ChiTietDonHangController {
    private final ChiTietDonHangService chiTietDonHangService;

    @PostMapping
    ApiRes<ChiTietDonHang> save(@RequestBody ChiTietDonHang chiTietDonHang) {
        return chiTietDonHangService.save(chiTietDonHang);
    }

    @GetMapping
    ApiRes<List<ChiTietDonHang>> findAll() {
        return chiTietDonHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<ChiTietDonHang> findById(@PathVariable Integer id) {
        return chiTietDonHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return chiTietDonHangService.delete(id);
    }
}
package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DonHang;
import com.sd75.service.DonHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/don-hang")
@RequiredArgsConstructor
public class DonHangController {
    private final DonHangService donHangService;

    @PostMapping
    ApiRes<DonHang> save(@RequestBody DonHang donHang) {
        return donHangService.save(donHang);
    }

    @GetMapping
    ApiRes<List<DonHang>> findAll() {
        return donHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<DonHang> findById(@PathVariable Integer id) {
        return donHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return donHangService.delete(id);
    }
}
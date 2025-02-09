package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.PhieuGiamGia;
import com.sd75.service.PhieuGiamGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/phieu-giam-gia")
@RequiredArgsConstructor
public class PhieuGiamGiaController {
    private final PhieuGiamGiaService phieuGiamGiaService;

    @PostMapping
    ApiRes<PhieuGiamGia> save(@RequestBody PhieuGiamGia phieuGiamGia) {
        return phieuGiamGiaService.save(phieuGiamGia);
    }

    @GetMapping
    ApiRes<List<PhieuGiamGia>> findAll() {
        return phieuGiamGiaService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<PhieuGiamGia> findById(@PathVariable Integer id) {
        return phieuGiamGiaService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return phieuGiamGiaService.delete(id);
    }
}
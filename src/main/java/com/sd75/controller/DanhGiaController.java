package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DanhGia;
import com.sd75.service.DanhGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/danh-gia")
@RequiredArgsConstructor
public class DanhGiaController {
    private final DanhGiaService danhGiaService;

    @PostMapping
    ApiRes<DanhGia> save(@RequestBody DanhGia danhGia) {
        return danhGiaService.save(danhGia);
    }

    @GetMapping
    ApiRes<List<DanhGia>> findAll() {
        return danhGiaService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<DanhGia> findById(@PathVariable Integer id) {
        return danhGiaService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return danhGiaService.delete(id);
    }
}
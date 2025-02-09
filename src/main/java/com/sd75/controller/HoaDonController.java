package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HoaDon;
import com.sd75.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonService hoaDonService;

    @PostMapping
    ApiRes<HoaDon> save(@RequestBody HoaDon hoaDon) {
        return hoaDonService.save(hoaDon);
    }

    @GetMapping
    ApiRes<List<HoaDon>> findAll() {
        return hoaDonService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<HoaDon> findById(@PathVariable Integer id) {
        return hoaDonService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return hoaDonService.delete(id);
    }
}
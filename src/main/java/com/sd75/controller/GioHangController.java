package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.GioHang;
import com.sd75.service.GioHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gio-hang")
@RequiredArgsConstructor
public class GioHangController {
    private final GioHangService gioHangService;

    @PostMapping
    ApiRes<GioHang> save(@RequestBody GioHang gioHang) {
        return gioHangService.save(gioHang);
    }

    @GetMapping
    ApiRes<List<GioHang>> findAll() {
        return gioHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<GioHang> findById(@PathVariable Integer id) {
        return gioHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return gioHangService.delete(id);
    }
}
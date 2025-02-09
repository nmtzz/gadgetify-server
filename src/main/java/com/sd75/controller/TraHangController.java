package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.TraHang;
import com.sd75.service.TraHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tra-hang")
@RequiredArgsConstructor
public class TraHangController {
    private final TraHangService traHangService;

    @PostMapping
    ApiRes<TraHang> save(@RequestBody TraHang traHang) {
        return traHangService.save(traHang);
    }

    @GetMapping
    ApiRes<List<TraHang>> findAll() {
        return traHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<TraHang> findById(@PathVariable Integer id) {
        return traHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return traHangService.delete(id);
    }
}
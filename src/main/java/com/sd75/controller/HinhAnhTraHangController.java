package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HinhAnhTraHang;
import com.sd75.service.HinhAnhTraHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hinh-anh-tra-hang")
@RequiredArgsConstructor
public class HinhAnhTraHangController {
    private final HinhAnhTraHangService hinhAnhTraHangService;

    @PostMapping
    ApiRes<HinhAnhTraHang> save(@RequestBody HinhAnhTraHang hinhAnhTraHang) {
        return hinhAnhTraHangService.save(hinhAnhTraHang);
    }

    @GetMapping
    ApiRes<List<HinhAnhTraHang>> findAll() {
        return hinhAnhTraHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<HinhAnhTraHang> findById(@PathVariable Integer id) {
        return hinhAnhTraHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return hinhAnhTraHangService.delete(id);
    }
}
package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ThongTinHoanTienTraHang;
import com.sd75.service.ThongTinHoanTienTraHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/thong-tin-hoan-tien-tra-hang")
@RequiredArgsConstructor
public class ThongTinHoanTienTraHangController {
    private final ThongTinHoanTienTraHangService thongTinHoanTienTraHangService;

    @PostMapping
    ApiRes<ThongTinHoanTienTraHang> save(@RequestBody ThongTinHoanTienTraHang thongTinHoanTienTraHang) {
        return thongTinHoanTienTraHangService.save(thongTinHoanTienTraHang);
    }

    @GetMapping
    ApiRes<List<ThongTinHoanTienTraHang>> findAll() {
        return thongTinHoanTienTraHangService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<ThongTinHoanTienTraHang> findById(@PathVariable Integer id) {
        return thongTinHoanTienTraHangService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return thongTinHoanTienTraHangService.delete(id);
    }
}
package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DanhMuc;
import com.sd75.service.DanhMucService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/danh-muc")
@RequiredArgsConstructor
public class DanhMucController {
    private final DanhMucService danhMucService;

    @PostMapping
    ApiRes<DanhMuc> save(@RequestBody DanhMuc danhMuc) {
        return danhMucService.save(danhMuc);
    }

    @GetMapping
    ApiRes<List<DanhMuc>> findAll() {
        return danhMucService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<DanhMuc> findById(@PathVariable Integer id) {
        return danhMucService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return danhMucService.delete(id);
    }
}
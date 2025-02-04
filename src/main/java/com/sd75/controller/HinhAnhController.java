package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HinhAnh;
import com.sd75.service.HinhAnhService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hinh-anh")
@RequiredArgsConstructor
public class HinhAnhController {
    private final HinhAnhService hinhAnhService;

    @PostMapping
    ApiRes<HinhAnh> save(@RequestBody HinhAnh hinhAnh) {
        return hinhAnhService.save(hinhAnh);
    }

    @GetMapping
    ApiRes<List<HinhAnh>> findAll() {
        return hinhAnhService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<HinhAnh> findById(@PathVariable Integer id) {
        return hinhAnhService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return hinhAnhService.delete(id);
    }
}
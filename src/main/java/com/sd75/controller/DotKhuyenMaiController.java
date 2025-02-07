package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DotKhuyenMai;
import com.sd75.service.DotKhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dot-khuyen-mai")
@RequiredArgsConstructor
public class DotKhuyenMaiController {
    private final DotKhuyenMaiService dotKhuyenMaiService;

    @PostMapping
    ApiRes<DotKhuyenMai> save(@RequestBody DotKhuyenMai dotKhuyenMai) {
        return dotKhuyenMaiService.save(dotKhuyenMai);
    }

    @GetMapping
    ApiRes<List<DotKhuyenMai>> findAll() {
        return dotKhuyenMaiService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<DotKhuyenMai> findById(@PathVariable Integer id) {
        return dotKhuyenMaiService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return dotKhuyenMaiService.delete(id);
    }
}
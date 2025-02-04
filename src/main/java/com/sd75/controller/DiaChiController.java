package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DiaChi;
import com.sd75.service.DiaChiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dia-chi")
@RequiredArgsConstructor
public class DiaChiController {
    private final DiaChiService diaChiService;

    @PostMapping
    ApiRes<DiaChi> save(@RequestBody DiaChi diaChi) {
        return diaChiService.save(diaChi);
    }

    @GetMapping
    ApiRes<List<DiaChi>> findAll() {
        return diaChiService.findAll();
    }

    @GetMapping("/{id}")
    ApiRes<DiaChi> findById(@PathVariable Integer id) {
        return diaChiService.findById(id);
    }

    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return diaChiService.delete(id);
    }
}
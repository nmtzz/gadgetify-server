package com.sd75.controller;

import com.sd75.dto.ApiRes;
import com.sd75.entity.NguoiDung;
import com.sd75.service.NguoiDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nguoi-dung")
@RequiredArgsConstructor
public class NguoiDungController {
    private final NguoiDungService nguoiDungService;
    @PostMapping
    ApiRes<NguoiDung> save(@RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.save(nguoiDung);
    }
    @GetMapping
    ApiRes<List<NguoiDung>> findAll() {
        return nguoiDungService.findAll();
    }
    @GetMapping("/{id}")
    ApiRes<NguoiDung> findById(@PathVariable Integer id) {
        return nguoiDungService.findById(id);
    }
    @DeleteMapping("/{id}")
    ApiRes<Void> delete(@PathVariable Integer id) {
        return nguoiDungService.delete(id);
    }

}

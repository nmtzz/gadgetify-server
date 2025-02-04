package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DiaChi;
import com.sd75.repository.DiaChiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaChiService {
    private final DiaChiRepository diaChiRepository;

    public ApiRes<DiaChi> save(DiaChi diaChi) {
        return ApiRes.<DiaChi>builder()
                .data(diaChiRepository.save(diaChi))
                .build();
    }

    public ApiRes<List<DiaChi>> findAll() {
        return ApiRes.<List<DiaChi>>builder()
                .data(diaChiRepository.findAll())
                .build();
    }

    public ApiRes<DiaChi> findById(Integer id) {
        DiaChi diaChi = diaChiRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy địa chỉ"));
        return ApiRes.<DiaChi>builder()
                .data(diaChi)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (diaChiRepository.existsById(id)) {
            diaChiRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy địa chỉ");
    }
}
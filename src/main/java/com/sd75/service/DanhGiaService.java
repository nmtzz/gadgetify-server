package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DanhGia;
import com.sd75.repository.DanhGiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhGiaService {
    private final DanhGiaRepository danhGiaRepository;

    public ApiRes<DanhGia> save(DanhGia danhGia) {
        return ApiRes.<DanhGia>builder()
                .data(danhGiaRepository.save(danhGia))
                .build();
    }

    public ApiRes<List<DanhGia>> findAll() {
        return ApiRes.<List<DanhGia>>builder()
                .data(danhGiaRepository.findAll())
                .build();
    }

    public ApiRes<DanhGia> findById(Integer id) {
        DanhGia danhGia = danhGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đánh giá"));
        return ApiRes.<DanhGia>builder()
                .data(danhGia)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (danhGiaRepository.existsById(id)) {
            danhGiaRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy đánh giá");
    }
}
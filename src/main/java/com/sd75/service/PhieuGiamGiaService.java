package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.PhieuGiamGia;
import com.sd75.repository.PhieuGiamGiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhieuGiamGiaService {
    private final PhieuGiamGiaRepository phieuGiamGiaRepository;

    public ApiRes<PhieuGiamGia> save(PhieuGiamGia phieuGiamGia) {
        return ApiRes.<PhieuGiamGia>builder()
                .data(phieuGiamGiaRepository.save(phieuGiamGia))
                .build();
    }

    public ApiRes<List<PhieuGiamGia>> findAll() {
        return ApiRes.<List<PhieuGiamGia>>builder()
                .data(phieuGiamGiaRepository.findAll())
                .build();
    }

    public ApiRes<PhieuGiamGia> findById(Integer id) {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu giảm giá"));
        return ApiRes.<PhieuGiamGia>builder()
                .data(phieuGiamGia)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (phieuGiamGiaRepository.existsById(id)) {
            phieuGiamGiaRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy phiếu giảm giá");
    }
}
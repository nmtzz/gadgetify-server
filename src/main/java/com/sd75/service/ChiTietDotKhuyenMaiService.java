package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietDotKhuyenMai;
import com.sd75.repository.ChiTietDotKhuyenMaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChiTietDotKhuyenMaiService {
    private final ChiTietDotKhuyenMaiRepository chiTietDotKhuyenMaiRepository;

    public ApiRes<ChiTietDotKhuyenMai> save(ChiTietDotKhuyenMai chiTietDotKhuyenMai) {
        return ApiRes.<ChiTietDotKhuyenMai>builder()
                .data(chiTietDotKhuyenMaiRepository.save(chiTietDotKhuyenMai))
                .build();
    }

    public ApiRes<List<ChiTietDotKhuyenMai>> findAll() {
        return ApiRes.<List<ChiTietDotKhuyenMai>>builder()
                .data(chiTietDotKhuyenMaiRepository.findAll())
                .build();
    }

    public ApiRes<ChiTietDotKhuyenMai> findById(Integer id) {
        ChiTietDotKhuyenMai chiTietDotKhuyenMai = chiTietDotKhuyenMaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết đợt khuyến mãi"));
        return ApiRes.<ChiTietDotKhuyenMai>builder()
                .data(chiTietDotKhuyenMai)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (chiTietDotKhuyenMaiRepository.existsById(id)) {
            chiTietDotKhuyenMaiRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy chi tiết đợt khuyến mãi");
    }
}
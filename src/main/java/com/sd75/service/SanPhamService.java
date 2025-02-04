package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.SanPham;
import com.sd75.repository.SanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamService {
    private final SanPhamRepository sanPhamRepository;

    public ApiRes<SanPham> save(SanPham sanPham) {
        return ApiRes.<SanPham>builder()
                .data(sanPhamRepository.save(sanPham))
                .build();
    }

    public ApiRes<List<SanPham>> findAll() {
        return ApiRes.<List<SanPham>>builder()
                .data(sanPhamRepository.findAll())
                .build();
    }

    public ApiRes<SanPham> findById(Integer id) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        return ApiRes.<SanPham>builder()
                .data(sanPham)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy sản phẩm");
    }
}
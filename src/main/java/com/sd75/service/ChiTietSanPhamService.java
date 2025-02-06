package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietSanPham;
import com.sd75.repository.ChiTietSanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChiTietSanPhamService {
    private final ChiTietSanPhamRepository chiTietSanPhamRepository;

    public ApiRes<ChiTietSanPham> save(ChiTietSanPham chiTietSanPham) {
        return ApiRes.<ChiTietSanPham>builder()
                .data(chiTietSanPhamRepository.save(chiTietSanPham))
                .build();
    }

    public ApiRes<List<ChiTietSanPham>> findAll() {
        return ApiRes.<List<ChiTietSanPham>>builder()
                .data(chiTietSanPhamRepository.findAll())
                .build();
    }

    public ApiRes<ChiTietSanPham> findById(Integer id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết sản phẩm"));
        return ApiRes.<ChiTietSanPham>builder()
                .data(chiTietSanPham)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (chiTietSanPhamRepository.existsById(id)) {
            chiTietSanPhamRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy chi tiết sản phẩm");
    }
}
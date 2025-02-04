package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HinhAnh;
import com.sd75.repository.HinhAnhRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HinhAnhService {
    private final HinhAnhRepository hinhAnhRepository;

    public ApiRes<HinhAnh> save(HinhAnh hinhAnh) {
        return ApiRes.<HinhAnh>builder()
                .data(hinhAnhRepository.save(hinhAnh))
                .build();
    }

    public ApiRes<List<HinhAnh>> findAll() {
        return ApiRes.<List<HinhAnh>>builder()
                .data(hinhAnhRepository.findAll())
                .build();
    }

    public ApiRes<HinhAnh> findById(Integer id) {
        HinhAnh hinhAnh = hinhAnhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hình ảnh"));
        return ApiRes.<HinhAnh>builder()
                .data(hinhAnh)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (hinhAnhRepository.existsById(id)) {
            hinhAnhRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy hình ảnh");
    }
}
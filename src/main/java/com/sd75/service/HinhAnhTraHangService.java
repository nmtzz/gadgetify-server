package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HinhAnhTraHang;
import com.sd75.repository.HinhAnhTraHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HinhAnhTraHangService {
    private final HinhAnhTraHangRepository hinhAnhTraHangRepository;

    public ApiRes<HinhAnhTraHang> save(HinhAnhTraHang hinhAnhTraHang) {
        return ApiRes.<HinhAnhTraHang>builder()
                .data(hinhAnhTraHangRepository.save(hinhAnhTraHang))
                .build();
    }

    public ApiRes<List<HinhAnhTraHang>> findAll() {
        return ApiRes.<List<HinhAnhTraHang>>builder()
                .data(hinhAnhTraHangRepository.findAll())
                .build();
    }

    public ApiRes<HinhAnhTraHang> findById(Integer id) {
        HinhAnhTraHang hinhAnhTraHang = hinhAnhTraHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hình ảnh trả hàng"));
        return ApiRes.<HinhAnhTraHang>builder()
                .data(hinhAnhTraHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (hinhAnhTraHangRepository.existsById(id)) {
            hinhAnhTraHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy hình ảnh trả hàng");
    }
}
package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.GioHang;
import com.sd75.repository.GioHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GioHangService {
    private final GioHangRepository gioHangRepository;

    public ApiRes<GioHang> save(GioHang gioHang) {
        return ApiRes.<GioHang>builder()
                .data(gioHangRepository.save(gioHang))
                .build();
    }

    public ApiRes<List<GioHang>> findAll() {
        return ApiRes.<List<GioHang>>builder()
                .data(gioHangRepository.findAll())
                .build();
    }

    public ApiRes<GioHang> findById(Integer id) {
        GioHang gioHang = gioHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng"));
        return ApiRes.<GioHang>builder()
                .data(gioHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (gioHangRepository.existsById(id)) {
            gioHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy giỏ hàng");
    }
}
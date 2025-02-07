package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ChiTietDonHang;
import com.sd75.repository.ChiTietDonHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChiTietDonHangService {
    private final ChiTietDonHangRepository chiTietDonHangRepository;

    public ApiRes<ChiTietDonHang> save(ChiTietDonHang chiTietDonHang) {
        return ApiRes.<ChiTietDonHang>builder()
                .data(chiTietDonHangRepository.save(chiTietDonHang))
                .build();
    }

    public ApiRes<List<ChiTietDonHang>> findAll() {
        return ApiRes.<List<ChiTietDonHang>>builder()
                .data(chiTietDonHangRepository.findAll())
                .build();
    }

    public ApiRes<ChiTietDonHang> findById(Integer id) {
        ChiTietDonHang chiTietDonHang = chiTietDonHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết đơn hàng"));
        return ApiRes.<ChiTietDonHang>builder()
                .data(chiTietDonHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (chiTietDonHangRepository.existsById(id)) {
            chiTietDonHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy chi tiết đơn hàng");
    }
}
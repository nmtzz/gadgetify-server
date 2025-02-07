package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DonHang;
import com.sd75.repository.DonHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonHangService {
    private final DonHangRepository donHangRepository;

    public ApiRes<DonHang> save(DonHang donHang) {
        return ApiRes.<DonHang>builder()
                .data(donHangRepository.save(donHang))
                .build();
    }

    public ApiRes<List<DonHang>> findAll() {
        return ApiRes.<List<DonHang>>builder()
                .data(donHangRepository.findAll())
                .build();
    }

    public ApiRes<DonHang> findById(Integer id) {
        DonHang donHang = donHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));
        return ApiRes.<DonHang>builder()
                .data(donHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (donHangRepository.existsById(id)) {
            donHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy đơn hàng");
    }
}
package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.TraHang;
import com.sd75.repository.TraHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraHangService {
    private final TraHangRepository traHangRepository;

    public ApiRes<TraHang> save(TraHang traHang) {
        return ApiRes.<TraHang>builder()
                .data(traHangRepository.save(traHang))
                .build();
    }

    public ApiRes<List<TraHang>> findAll() {
        return ApiRes.<List<TraHang>>builder()
                .data(traHangRepository.findAll())
                .build();
    }

    public ApiRes<TraHang> findById(Integer id) {
        TraHang traHang = traHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy trả hàng"));
        return ApiRes.<TraHang>builder()
                .data(traHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (traHangRepository.existsById(id)) {
            traHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy trả hàng");
    }
}
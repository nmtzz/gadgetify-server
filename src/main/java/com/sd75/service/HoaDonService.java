package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.HoaDon;
import com.sd75.repository.HoaDonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonService {
    private final HoaDonRepository hoaDonRepository;

    public ApiRes<HoaDon> save(HoaDon hoaDon) {
        return ApiRes.<HoaDon>builder()
                .data(hoaDonRepository.save(hoaDon))
                .build();
    }

    public ApiRes<List<HoaDon>> findAll() {
        return ApiRes.<List<HoaDon>>builder()
                .data(hoaDonRepository.findAll())
                .build();
    }

    public ApiRes<HoaDon> findById(Integer id) {
        HoaDon hoaDon = hoaDonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hóa đơn"));
        return ApiRes.<HoaDon>builder()
                .data(hoaDon)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (hoaDonRepository.existsById(id)) {
            hoaDonRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy hóa đơn");
    }
}
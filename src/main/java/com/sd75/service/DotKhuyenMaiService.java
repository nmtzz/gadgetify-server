package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DotKhuyenMai;
import com.sd75.repository.DotKhuyenMaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DotKhuyenMaiService {
    private final DotKhuyenMaiRepository dotKhuyenMaiRepository;

    public ApiRes<DotKhuyenMai> save(DotKhuyenMai dotKhuyenMai) {
        return ApiRes.<DotKhuyenMai>builder()
                .data(dotKhuyenMaiRepository.save(dotKhuyenMai))
                .build();
    }

    public ApiRes<List<DotKhuyenMai>> findAll() {
        return ApiRes.<List<DotKhuyenMai>>builder()
                .data(dotKhuyenMaiRepository.findAll())
                .build();
    }

    public ApiRes<DotKhuyenMai> findById(Integer id) {
        DotKhuyenMai dotKhuyenMai = dotKhuyenMaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đợt khuyến mãi"));
        return ApiRes.<DotKhuyenMai>builder()
                .data(dotKhuyenMai)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (dotKhuyenMaiRepository.existsById(id)) {
            dotKhuyenMaiRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy đợt khuyến mãi");
    }
}
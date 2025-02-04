package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.DanhMuc;
import com.sd75.repository.DanhMucRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucService {
    private final DanhMucRepository danhMucRepository;

    public ApiRes<DanhMuc> save(DanhMuc danhMuc) {
        return ApiRes.<DanhMuc>builder()
                .data(danhMucRepository.save(danhMuc))
                .build();
    }

    public ApiRes<List<DanhMuc>> findAll() {
        return ApiRes.<List<DanhMuc>>builder()
                .data(danhMucRepository.findAll())
                .build();
    }

    public ApiRes<DanhMuc> findById(Integer id) {
        DanhMuc danhMuc = danhMucRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục"));
        return ApiRes.<DanhMuc>builder()
                .data(danhMuc)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (danhMucRepository.existsById(id)) {
            danhMucRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy danh mục");
    }
}
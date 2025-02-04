package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.NguoiDung;
import com.sd75.repository.NguoiDungRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NguoiDungService {
    private final NguoiDungRepository nguoiDungRepository;

    public ApiRes<NguoiDung> save(NguoiDung nguoiDung) {
        return ApiRes.<NguoiDung>builder()
                .data(nguoiDungRepository.save(nguoiDung))
                .build();
    }
    public ApiRes<List<NguoiDung>> findAll() {
        return ApiRes.<List<NguoiDung>>builder()
                .data(nguoiDungRepository.findAll())
                .build();
    }
    public ApiRes<NguoiDung> findById(Integer id) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        return ApiRes.<NguoiDung>builder()
                .data(nguoiDung)
                .build();
    }
    public ApiRes<Void> delete(Integer id) {
        if (nguoiDungRepository.existsById(id)) {
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy người dùng");
    }

}


package com.sd75.service;

import com.sd75.dto.ApiRes;
import com.sd75.entity.ThongTinHoanTienTraHang;
import com.sd75.repository.ThongTinHoanTienTraHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThongTinHoanTienTraHangService {
    private final ThongTinHoanTienTraHangRepository thongTinHoanTienTraHangRepository;

    public ApiRes<ThongTinHoanTienTraHang> save(ThongTinHoanTienTraHang thongTinHoanTienTraHang) {
        return ApiRes.<ThongTinHoanTienTraHang>builder()
                .data(thongTinHoanTienTraHangRepository.save(thongTinHoanTienTraHang))
                .build();
    }

    public ApiRes<List<ThongTinHoanTienTraHang>> findAll() {
        return ApiRes.<List<ThongTinHoanTienTraHang>>builder()
                .data(thongTinHoanTienTraHangRepository.findAll())
                .build();
    }

    public ApiRes<ThongTinHoanTienTraHang> findById(Integer id) {
        ThongTinHoanTienTraHang thongTinHoanTienTraHang = thongTinHoanTienTraHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin hoàn tiền trả hàng"));
        return ApiRes.<ThongTinHoanTienTraHang>builder()
                .data(thongTinHoanTienTraHang)
                .build();
    }

    public ApiRes<Void> delete(Integer id) {
        if (thongTinHoanTienTraHangRepository.existsById(id)) {
            thongTinHoanTienTraHangRepository.deleteById(id);
            return ApiRes.<Void>builder().build();
        }
        throw new RuntimeException("Không tìm thấy thông tin hoàn tiền trả hàng");
    }
}
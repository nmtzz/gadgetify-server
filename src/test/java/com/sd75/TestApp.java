package com.sd75;

import com.sd75.dto.ApiRes;
import com.sd75.entity.GioHang;
import com.sd75.service.GioHangService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class TestApp {
    @Autowired
    private GioHangService gioHangService;
    @Test
    void test() {
        ApiRes<GioHang> apiRes = gioHangService.findById(1);
        System.out.println(apiRes.toString());
        System.out.println(apiRes.getData().getId());
    }
}

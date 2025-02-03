package com.sd75.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "phieu_giam_gia")
public class PhieuGiamGia {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nationalized
    @Column(name = "ma_phieu_giam_gia", length = 50)
    private String maPhieuGiamGia;

    @Column(name = "loai_giam_gia", columnDefinition = "tinyint")
    private Short loaiGiamGia;

    @Column(name = "gia_tri_giam_gia")
    private BigDecimal giaTriGiamGia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "gia_tri_don_hang_toi_thieu")
    private BigDecimal giaTriDonHangToiThieu;

    @Column(name = "gia_tri_toi_da_giam_gia")
    private BigDecimal giaTriToiDaGiamGia;

    @Column(name = "ngay_bat_dau")
    private Instant ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Instant ngayKetThuc;

}
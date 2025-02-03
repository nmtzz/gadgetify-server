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
@Table(name = "dot_khuyen_mai")
public class DotKhuyenMai {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nationalized
    @Column(name = "ten_dot_khuyen_mai")
    private String tenDotKhuyenMai;

    @Column(name = "loai_giam_gia", columnDefinition = "tinyint")
    private Short loaiGiamGia;

    @Column(name = "gia_tri_giam_gia")
    private BigDecimal giaTriGiamGia;

    @Column(name = "ngay_bat_dau")
    private Instant ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Instant ngayKetThuc;

}
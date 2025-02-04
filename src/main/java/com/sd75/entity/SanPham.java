package com.sd75.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_danh_muc")
    @JsonIgnore
    private DanhMuc danhMuc;

    @Nationalized
    @Column(name = "ma_san_pham", length = 50)
    private String maSanPham;

    @Nationalized
    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Nationalized
    @Column(name = "anh_dai_dien")
    private String anhDaiDien;

    @Column(name = "gia_co_so")
    private BigDecimal giaCoSo;

    @Column(name = "can_nang")
    private Integer canNang;

    @Nationalized
    @Column(name = "mo_ta", length = 400)
    private String moTa;

    @Nationalized
    @Lob
    @Column(name = "thong_so_json")
    private String thongSoJson;

}
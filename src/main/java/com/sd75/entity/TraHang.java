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
@Table(name = "tra_hang")
public class TraHang {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chi_tiet_don_hang")
    private ChiTietDonHang idChiTietDonHang;

    @Column(name = "so_luong_tra")
    private Integer soLuongTra;

    @Nationalized
    @Column(name = "ly_do")
    private String lyDo;

    @Column(name = "trang_thai", columnDefinition = "tinyint")
    private Short trangThai;

    @Column(name = "tien_tra")
    private BigDecimal tienTra;

    @Column(name = "ngay_tao")
    private Instant ngayTao;

    @Column(name = "ngay_cap_nhat")
    private Instant ngayCapNhat;

}
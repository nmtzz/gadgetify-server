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
@Table(name = "don_hang")
public class DonHang {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung idNguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_phieu_giam_gia")
    private PhieuGiamGia idPhieuGiamGia;

    @Nationalized
    @Column(name = "ma_don_hang", length = 50)
    private String maDonHang;

    @Column(name = "tong_tien")
    private BigDecimal tongTien;

    @Column(name = "trang_thai", columnDefinition = "tinyint")
    private Short trangThai;

    @Column(name = "phuong_thuc_thanh_toan", columnDefinition = "tinyint")
    private Short phuongThucThanhToan;

    @Nationalized
    @Column(name = "so_dien_thoai_nguoi_nhan", length = 25)
    private String soDienThoaiNguoiNhan;

    @Nationalized
    @Column(name = "dia_chi_giao_hang", length = 1000)
    private String diaChiGiaoHang;

    @Column(name = "ngay_tao")
    private Instant ngayTao;

}
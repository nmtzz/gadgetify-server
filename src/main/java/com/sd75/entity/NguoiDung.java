package com.sd75.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nationalized
    @Column(name = "sdt", length = 25)
    private String sdt;

    @Nationalized
    @Column(name = "email")
    private String email;

    @Nationalized
    @Column(name = "ho_ten")
    private String hoTen;

    @Nationalized
    @Column(name = "mat_khau")
    private String matKhau;

    @ColumnDefault("0")
    @Column(name = "vai_tro", columnDefinition = "tinyint")
    private Short vaiTro;

    @ColumnDefault("1")
    @Column(name = "trang_thai")
    private Boolean trangThai;

    @Nationalized
    @Column(name = "refesh_token")
    private String refeshToken;

}
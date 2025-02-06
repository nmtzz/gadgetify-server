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
@Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_san_pham")
    @JsonIgnore
    private SanPham sanPham;

    @Nationalized
    @Column(name = "sku", length = 50)
    private String sku;

    @Nationalized
    @Column(name = "mau_sac", length = 50)
    private String mauSac;

    @Nationalized
    @Lob
    @Column(name = "bien_the_json")
    private String bienTheJson;

    @Column(name = "gia_bien_the")
    private BigDecimal giaBienThe;

    @Column(name = "ton_kho")
    private Integer tonKho;

}
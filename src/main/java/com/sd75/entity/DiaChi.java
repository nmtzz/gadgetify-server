package com.sd75.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dia_chi")
@JsonIgnoreProperties({ "nguoiDung" })
public class DiaChi {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nguoi_dung")
    private NguoiDung nguoiDung;

    @Nationalized
    @Column(name = "xa")
    private String xa;

    @Nationalized
    @Column(name = "huyen")
    private String huyen;

    @Nationalized
    @Column(name = "tinh")
    private String tinh;

    @Nationalized
    @Column(name = "dia_chi_cu_the")
    private String diaChiCuThe;

}
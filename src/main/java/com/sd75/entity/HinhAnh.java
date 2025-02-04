package com.sd75.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hinh_anh")
public class HinhAnh {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_san_pham")
    @JsonIgnore
    private SanPham sanPham;

    @Nationalized
    @Column(name = "url")
    private String url;

    @Nationalized
    @Column(name = "public_id", length = 20)
    private String publicId;

}
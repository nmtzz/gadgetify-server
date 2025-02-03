package com.sd75.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thong_tin_hoan_tien_tra_hang")
public class ThongTinHoanTienTraHang {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tra_hang")
    private TraHang idTraHang;

    @Nationalized
    @Column(name = "ngan_hang_tra")
    private String nganHangTra;

    @Nationalized
    @Column(name = "stk_nguoi_tra", length = 25)
    private String stkNguoiTra;

    @Nationalized
    @Column(name = "anh_chup_bill_hoan_tien")
    private String anhChupBillHoanTien;

}
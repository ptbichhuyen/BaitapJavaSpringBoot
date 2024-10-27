package com.example.shopqualuuniem.model;
import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="hoa_don")
public class Hoadon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ma_hoa_don;
    private OffsetDateTime ngay_ban;
    private float tong_tien;
    private Integer ma_trang_thai;
    private Integer ma_kh;

    public Hoadon() {}
    public Hoadon(OffsetDateTime ngay_ban, float tong_tien, Integer ma_trang_thai, Integer ma_kh){
        this.ngay_ban = ngay_ban;
        this.tong_tien = tong_tien;
        this.ma_trang_thai = ma_trang_thai;
        this.ma_kh = ma_kh;
    }
    @PrePersist
    protected void onCreate(){
        this.ngay_ban = OffsetDateTime.now();
    }
    public Integer getma_hoa_don(){return ma_hoa_don;}
    public void setma_hoa_don(Integer ma_hoa_don){
        this.ma_hoa_don = ma_hoa_don;
    }
    public OffsetDateTime getngay_ban(){
        return ngay_ban;
    }
    public void setngay_ban(OffsetDateTime ngay_ban){
        this.ngay_ban = ngay_ban;
    }
    public float gettong_tien(){
        return tong_tien;
    }
    public void settong_tien(float tong_tien){
        this.tong_tien = tong_tien;
    }
    public Integer getma_trang_thai(){ return ma_trang_thai; }
    public void setma_trang_thai(Integer ma_trang_thai){this.ma_trang_thai = ma_trang_thai; }
    public Integer getma_kh(){return ma_kh;}
    public void setma_kh(Integer ma_kh){this.ma_kh = ma_kh;}
}

package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loai")
public class Loai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_loai;
    private String ten_loai;

    public Loai(){}
    public Loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
    public Integer getma_loai() { return ma_loai;}
    public void setma_loai(Integer ma_loai) {this.ma_loai = ma_loai; }
    public String getten_loai() { return ten_loai;}
    public void setten_loai (String ten_loai) {this.ten_loai = ten_loai; }
}

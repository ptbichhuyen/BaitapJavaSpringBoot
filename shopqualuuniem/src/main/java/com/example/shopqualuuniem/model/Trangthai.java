package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trang_thai")
public class Trangthai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_trang_thai;
    private String ten_trang_thai;

    public Trangthai() {}
    public Trangthai(String ten_trang_thai){
        this.ten_trang_thai = ten_trang_thai;

    }
    public Integer getma_trang_thai(){return ma_trang_thai;}
    public void setma_trang_thai(Integer ma_trang_thai){this.ma_trang_thai = ma_trang_thai;}
    public String getten_trang_thai(){return ten_trang_thai;}
    public void setten_trang_thai(String ten_trang_thai){this.ten_trang_thai = ten_trang_thai;}

}

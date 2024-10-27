package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gio_hang")
public class Giohang {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_gio_hang;
    private float gia_sp;
    private Integer ma_tai_khoan;
    private Integer ma_sp;

    public Giohang() {}
    public Giohang(float gia_sp, Integer ma_tai_khoan, Integer ma_sp){
        this.gia_sp = gia_sp;
        this.ma_tai_khoan = ma_tai_khoan;
        this.ma_sp = ma_sp;
    }
    public Integer getma_gio_hang(){
        return ma_gio_hang;
    }
    public void setma_gio_hang(Integer ma_gio_hang){this.ma_gio_hang = ma_gio_hang;}
    public float getgia_sp(){
        return gia_sp;
    }
    public void setgia_sp(float gia_sp){
        this.gia_sp = gia_sp;
    }
    public Integer getma_tai_khoan(){
        return ma_tai_khoan;
    }
    public void setma_tai_khoan(Integer ma_tai_khoan){
        this.ma_tai_khoan = ma_tai_khoan;
    }
    public Integer getma_sp(){
        return ma_sp;
    }
    public void setma_sp(Integer ma_sp){
        this.ma_sp = ma_sp;
    }
}

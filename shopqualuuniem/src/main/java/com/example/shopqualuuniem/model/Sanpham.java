package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="san_pham")
public class Sanpham {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_sp;
    private String ten_sp;
    private String anh_sp;
    private Integer so_luong_ton;
    private float gia;
    private String mo_ta;
    private Integer ma_loai;

    public Sanpham() {}
    public Sanpham(String ten_sp, String anh_sp, Integer so_luong_ton, float gia, String mo_ta, Integer ma_loai){
        this.ten_sp = ten_sp;
        this.anh_sp = anh_sp;
        this.so_luong_ton = so_luong_ton;
        this.gia = gia;
        this.mo_ta = mo_ta;
        this.ma_loai = ma_loai;
    }
    public Integer getma_sp(){
        return ma_sp;
    }
    public void setma_sp(Integer ma_sp){
        this.ma_sp = ma_sp;
    }
    public String getten_sp(){
        return ten_sp;
    }
    public void setten_sp(String ten_sp){
        this.ten_sp = ten_sp;
    }
    public String getanh_sp(){
        return anh_sp;
    }
    public void setanh_sp(String anh_sp){
        this.anh_sp = anh_sp;
    }
    public Integer getso_luong_ton(){return so_luong_ton;}
    public void setso_luong_ton(Integer so_luong_ton){this.so_luong_ton = so_luong_ton; }
    public float getgia(){return gia;}
    public void setgia(float gia){this.gia = gia;}
    public String getmo_ta(){return mo_ta;}
    public void setmo_ta(String mo_ta){this.mo_ta = mo_ta;}
    public Integer getma_loai(){return ma_loai;}
    public void setma_loai(Integer ma_loai){this.ma_loai = ma_loai;}
}

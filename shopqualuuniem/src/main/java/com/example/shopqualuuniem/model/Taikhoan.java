package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tai_khoan")
public class Taikhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ma_tai_khoan;
    private String email;
    private String mat_khau;
    private Integer ma_vai_tro;
    private Integer ma_kh;

    public Taikhoan() {}
    public Taikhoan(String email, String mat_khau, Integer ma_vai_tro, Integer ma_kh) {
        this.email = email;
        this.mat_khau = mat_khau;
        this.ma_vai_tro = ma_vai_tro;
        this.ma_kh = ma_kh;
    }

    public Integer getma_tai_khoan() {return ma_tai_khoan;}
    public void setma_tai_khoan(Integer ma_tai_khoan) {this.ma_tai_khoan = ma_tai_khoan;}
    public String getemail() {return email;}
    public void setemail(String email) {this.email = email;}
    public String getmat_khau() {return mat_khau;}
    public void setmat_khau(String mat_khau) {this.mat_khau = mat_khau;}
    public Integer getma_vai_tro() {return ma_vai_tro;}
    public void setma_vai_tro(Integer ma_vai_tro) {this.ma_vai_tro = ma_vai_tro;}
    public Integer getma_kh(){return ma_kh;}
    public void setma_kh(Integer ma_kh) {this.ma_kh = ma_kh;}
}

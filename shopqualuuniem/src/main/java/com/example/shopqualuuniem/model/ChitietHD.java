package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chi_tiet_hd")
public class ChitietHD {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_chi_tiet;
    private Integer sl_san_pham;
    private float gia_ban;
    private Integer ma_hoa_don;
    private Integer ma_sp;

    public ChitietHD() {}
    public ChitietHD(Integer sl_san_pham, float gia_ban, Integer ma_hoa_don, Integer ma_sp){
        this.sl_san_pham = sl_san_pham;
        this.gia_ban = gia_ban;
        this.ma_hoa_don = ma_hoa_don;
        this.ma_sp = ma_sp;
    }
    public Integer getma_chi_tiet(){return ma_chi_tiet;}
    public void setma_chi_tiet(Integer ma_chi_tiet){
        this.ma_chi_tiet = ma_chi_tiet;
    }
    public Integer getsl_san_pham(){
        return sl_san_pham;
    }
    public void setsl_san_pham(Integer sl_san_pham){
        this.sl_san_pham = sl_san_pham;
    }
    public float getgia_ban(){
        return gia_ban;
    }
    public void setgia_ban(float gia_ban){
        this.gia_ban = gia_ban;
    }
    public Integer getma_hoa_don() { return ma_hoa_don; }
    public void setma_hoa_don(Integer ma_hoa_don){this.ma_hoa_don = ma_hoa_don; }
    public Integer getma_sp(){return ma_sp;}
    public void setma_sp(Integer ma_sp){this.ma_sp = ma_sp;}
}

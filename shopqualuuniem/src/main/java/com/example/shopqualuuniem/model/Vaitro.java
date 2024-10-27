package com.example.shopqualuuniem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vai_tro")
public class Vaitro {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ma_vai_tro;
    private String ten_vai_tro;

    public Vaitro(){}
    public Vaitro(String ten_vai_tro){
        this.ten_vai_tro = ten_vai_tro;

    }
    public String getten_vai_tro() { return ten_vai_tro;}
    public void setten_vai_tro(String ten_vai_tro) {this.ten_vai_tro = ten_vai_tro;}
    public Integer getma_vai_tro() { return ma_vai_tro;}
    public void setma_vai_tro(Integer ma_vai_tro) {this.ma_vai_tro = ma_vai_tro;}

}

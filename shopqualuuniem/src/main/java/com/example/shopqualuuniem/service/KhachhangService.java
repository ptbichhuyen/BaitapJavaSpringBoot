package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Khachhang;
import com.example.shopqualuuniem.repostory.KhachhangRepos;


@Service
public class KhachhangService {
    @Autowired
    private KhachhangRepos KhachhangRepos;

    public List<Khachhang> findAll(){
        return KhachhangRepos.findAll();
    }
    public Optional<Khachhang> findById(Integer Id){
        return KhachhangRepos.findById(Id);
    }
    public Khachhang save(Khachhang khachhang){
        return KhachhangRepos.save(khachhang);
    }
    public void deleteById(Integer Id){
        KhachhangRepos.deleteById(Id);
    }
}

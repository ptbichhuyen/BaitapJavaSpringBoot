package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Taikhoan;
import com.example.shopqualuuniem.repostory.TaikhoanRepos;


@Service
public class TaikhoanService {
    @Autowired
    private TaikhoanRepos TaikhoanRepos;

    public List<Taikhoan> findAll(){
        return TaikhoanRepos.findAll();
    }
    public Optional<Taikhoan> findById(Integer Id){
        return TaikhoanRepos.findById(Id);
    }
    public Taikhoan save(Taikhoan taikhoan){
        return TaikhoanRepos.save(taikhoan);
    }
    public void deleteById(Integer Id){
        TaikhoanRepos.deleteById(Id);
    }
}

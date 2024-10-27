package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Sanpham;
import com.example.shopqualuuniem.repostory.SanphamRepos;


@Service
public class SanphamService {
    @Autowired
    private SanphamRepos SanphamRepos;

    public List<Sanpham> findAll(){
        return SanphamRepos.findAll();
    }
    public Optional<Sanpham> findById(Integer Id){
        return SanphamRepos.findById(Id);
    }
    public Sanpham save(Sanpham sanpham){
        return SanphamRepos.save(sanpham);
    }
    public void deleteById(Integer Id){
        SanphamRepos.deleteById(Id);
    }
}


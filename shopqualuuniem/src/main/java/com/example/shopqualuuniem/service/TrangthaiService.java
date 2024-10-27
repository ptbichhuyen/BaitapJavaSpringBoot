package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Trangthai;
import com.example.shopqualuuniem.repostory.TrangthaiRepos;



@Service
public class TrangthaiService {
    @Autowired
    private TrangthaiRepos TrangthaiRepos;

    public List<Trangthai> findAll(){
        return TrangthaiRepos.findAll();
    }
    public Optional<Trangthai> findById(Integer Id){
        return TrangthaiRepos.findById(Id);
    }
    public Trangthai save(Trangthai trangthai){
        return TrangthaiRepos.save(trangthai);
    }
    public void deleteById(Integer Id){
        TrangthaiRepos.deleteById(Id);
    }
}

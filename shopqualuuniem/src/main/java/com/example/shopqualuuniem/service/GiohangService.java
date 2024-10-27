package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Giohang;
import com.example.shopqualuuniem.repostory.GiohangRepos;


@Service
public class GiohangService {
    @Autowired
    private GiohangRepos GiohangRepos;

    public List<Giohang> findAll(){
        return GiohangRepos.findAll();
    }
    public Optional<Giohang> findById(Integer Id){
        return GiohangRepos.findById(Id);
    }
    public Giohang save(Giohang giohang){
        return GiohangRepos.save(giohang);
    }
    public void deleteById(Integer Id){
        GiohangRepos.deleteById(Id);
    }
}

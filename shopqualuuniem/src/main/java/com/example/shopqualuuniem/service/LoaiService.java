package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Loai;
import com.example.shopqualuuniem.repostory.LoaiRepos;



@Service
public class LoaiService {
    @Autowired
    private LoaiRepos LoaiRepos;

    public List<Loai> findAll(){
        return LoaiRepos.findAll();
    }
    public Optional<Loai> findById(Integer Id){
        return LoaiRepos.findById(Id);
    }
    public Loai save(Loai loai){
        return LoaiRepos.save(loai);
    }
    public void deleteById(Integer Id){
        LoaiRepos.deleteById(Id);
    }
}

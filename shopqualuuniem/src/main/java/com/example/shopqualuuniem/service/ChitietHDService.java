package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.ChitietHD;
import com.example.shopqualuuniem.repostory.ChitietHDRepos;

@Service
public class ChitietHDService {
    @Autowired
    private ChitietHDRepos ChitietHDRepos;

    public List<ChitietHD> findAll(){
        return ChitietHDRepos.findAll();
    }
    public Optional<ChitietHD> findById(Integer Id){
        return ChitietHDRepos.findById(Id);
    }
    public ChitietHD save(ChitietHD chitiet){
        return ChitietHDRepos.save(chitiet);
    }
    public void deleteById(Integer Id){
        ChitietHDRepos.deleteById(Id);
    }
}

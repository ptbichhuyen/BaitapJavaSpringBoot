package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Hoadon;
import com.example.shopqualuuniem.repostory.HoadonRepos;


@Service
public class HoadonService {
    @Autowired
    private HoadonRepos HoadonRepos;

    public List<Hoadon> findAll(){
        return HoadonRepos.findAll();
    }
    public Optional<Hoadon> findById(Integer Id){
        return HoadonRepos.findById(Id);
    }
    public Hoadon save(Hoadon hoadon){
        return HoadonRepos.save(hoadon);
    }
    public void deleteById(Integer Id){
        HoadonRepos.deleteById(Id);
    }
}

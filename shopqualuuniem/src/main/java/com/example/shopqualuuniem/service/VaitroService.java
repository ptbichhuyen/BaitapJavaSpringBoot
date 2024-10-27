package com.example.shopqualuuniem.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopqualuuniem.model.Vaitro;
import com.example.shopqualuuniem.repostory.VaitroRepos;


@Service
public class VaitroService {
    @Autowired
    private VaitroRepos VaitroRepos;

    public List<Vaitro> findAll(){
        return VaitroRepos.findAll();
    }
    public Optional<Vaitro> findById(Integer Id){
        return VaitroRepos.findById(Id);
    }
    public Vaitro save(Vaitro vaitro){
        return VaitroRepos.save(vaitro);
    }
    public void deleteById(Integer Id){
        VaitroRepos.deleteById(Id);
    }
}

package com.example.shopqualuuniem.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopqualuuniem.model.Loai;
import com.example.shopqualuuniem.service.LoaiService;


@RestController
@RequestMapping("/Loai")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class LoaiController {
    @Autowired
    private LoaiService LoaiService;

    @GetMapping("/getAllLoai")
    public List<Loai> getAllLoai(){
        return LoaiService.findAll();
    }
    @GetMapping("/getById/{ma_loai}")
    public ResponseEntity<Loai> getById(@PathVariable Integer ma_loai){
        Optional<Loai> loai = LoaiService.findById(ma_loai);
        return loai.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Loai createRole(@RequestBody Loai loai){
        return LoaiService.save(loai);
    }
    @PutMapping("/update/{ma_loai}")
    public ResponseEntity<Loai> updateRole(@PathVariable Integer ma_loai, @RequestBody Loai loai){
        if(LoaiService.findById(ma_loai).isPresent()){
            loai.setma_loai(ma_loai);
            return ResponseEntity.ok(LoaiService.save(loai));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_loai}")
    public ResponseEntity<Loai> deleteRole(@PathVariable Integer ma_loai){
        if(LoaiService.findById(ma_loai).isPresent()){
            LoaiService.deleteById(ma_loai);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

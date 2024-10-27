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

import com.example.shopqualuuniem.model.Khachhang;
import com.example.shopqualuuniem.service.KhachhangService;


@RestController
@RequestMapping("/Khachhang")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class KhachhangController {
    @Autowired
    private KhachhangService KhachhangService;

    @GetMapping("/getAllKhachhang")
    public List<Khachhang> getAllKhachhang(){
        return KhachhangService.findAll();
    }
    @GetMapping("/getById/{ma_kh}")
    public ResponseEntity<Khachhang> getById(@PathVariable Integer ma_kh){
        Optional<Khachhang> khachhang = KhachhangService.findById(ma_kh);
        return khachhang.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Khachhang createRole(@RequestBody Khachhang khachhang){
        return KhachhangService.save(khachhang);
    }
    @PutMapping("/update/{ma_kh}")
    public ResponseEntity<Khachhang> updateRole(@PathVariable Integer ma_kh, @RequestBody Khachhang khachhang){
        if(KhachhangService.findById(ma_kh).isPresent()){
            khachhang.setma_kh(ma_kh);
            return ResponseEntity.ok(KhachhangService.save(khachhang));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_kh}")
    public ResponseEntity<Khachhang> deleteRole(@PathVariable Integer ma_kh){
        if(KhachhangService.findById(ma_kh).isPresent()){
            KhachhangService.deleteById(ma_kh);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

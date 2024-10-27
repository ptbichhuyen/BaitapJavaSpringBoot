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

import com.example.shopqualuuniem.model.Taikhoan;
import com.example.shopqualuuniem.service.TaikhoanService;


@RestController
@RequestMapping("/Taikhoan")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class TaikhoanController {
    @Autowired
    private TaikhoanService TaikhoanService;

    @GetMapping("/getAllTaikhoan")
    public List<Taikhoan> getAllTaikhoan(){
        return TaikhoanService.findAll();
    }
    @GetMapping("/getById/{ma_tai_khoan}")
    public ResponseEntity<Taikhoan> getById(@PathVariable Integer ma_tai_khoan){
        Optional<Taikhoan> taikhoan = TaikhoanService.findById(ma_tai_khoan);
        return taikhoan.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Taikhoan createRole(@RequestBody Taikhoan taikhoan){
        return TaikhoanService.save(taikhoan);
    }
    @PutMapping("/update/{ma_tai_khoan}")
    public ResponseEntity<Taikhoan> updateRole(@PathVariable Integer ma_tai_khoan, @RequestBody Taikhoan taikhoan){
        if(TaikhoanService.findById(ma_tai_khoan).isPresent()){
            taikhoan.setma_tai_khoan(ma_tai_khoan);
            return ResponseEntity.ok(TaikhoanService.save(taikhoan));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_tai_khoan}")
    public ResponseEntity<Taikhoan> deleteRole(@PathVariable Integer ma_tai_khoan){
        if(TaikhoanService.findById(ma_tai_khoan).isPresent()){
            TaikhoanService.deleteById(ma_tai_khoan);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

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

import com.example.shopqualuuniem.model.Sanpham;
import com.example.shopqualuuniem.service.SanphamService;


@RestController
@RequestMapping("/Sanpham")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class SanphamController {
    @Autowired
    private SanphamService SanphamService;

    @GetMapping("/getAllSanpham")
    public List<Sanpham> getAllSanpham(){
        return SanphamService.findAll();
    }
    @GetMapping("/getById/{ma_sp}")
    public ResponseEntity<Sanpham> getById(@PathVariable Integer ma_sp){
        Optional<Sanpham> sanpham = SanphamService.findById(ma_sp);
        return sanpham.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Sanpham createRole(@RequestBody Sanpham sanpham){
        return SanphamService.save(sanpham);
    }
    @PutMapping("/update/{ma_sp}")
    public ResponseEntity<Sanpham> updateRole(@PathVariable Integer ma_sp, @RequestBody Sanpham sanpham){
        if(SanphamService.findById(ma_sp).isPresent()){
            sanpham.setma_sp(ma_sp);
            return ResponseEntity.ok(SanphamService.save(sanpham));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_sp}")
    public ResponseEntity<Sanpham> deleteRole(@PathVariable Integer ma_sp){
        if(SanphamService.findById(ma_sp).isPresent()){
            SanphamService.deleteById(ma_sp);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

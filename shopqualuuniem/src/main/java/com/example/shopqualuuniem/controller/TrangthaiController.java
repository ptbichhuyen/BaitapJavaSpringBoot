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

import com.example.shopqualuuniem.model.Trangthai;
import com.example.shopqualuuniem.service.TrangthaiService;


@RestController
@RequestMapping("/Trangthai")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class TrangthaiController {
    @Autowired
    private TrangthaiService TrangthaiService;

    @GetMapping("/getAllTrangthai")
    public List<Trangthai> getAllTrangthai(){
        return TrangthaiService.findAll();
    }
    @GetMapping("/getById/{ma_trang_thai}")
    public ResponseEntity<Trangthai> getById(@PathVariable Integer ma_trang_thai){
        Optional<Trangthai> trangthai = TrangthaiService.findById(ma_trang_thai);
        return trangthai.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Trangthai createRole(@RequestBody Trangthai trangthai){
        return TrangthaiService.save(trangthai);
    }
    @PutMapping("/update/{ma_trang_thai}")
    public ResponseEntity<Trangthai> updateRole(@PathVariable Integer ma_trang_thai, @RequestBody Trangthai trangthai){
        if(TrangthaiService.findById(ma_trang_thai).isPresent()){
            trangthai.setma_trang_thai(ma_trang_thai);
            return ResponseEntity.ok(TrangthaiService.save(trangthai));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_trang_thai}")
    public ResponseEntity<Trangthai> deleteRole(@PathVariable Integer ma_trang_thai){
        if(TrangthaiService.findById(ma_trang_thai).isPresent()){
            TrangthaiService.deleteById(ma_trang_thai);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

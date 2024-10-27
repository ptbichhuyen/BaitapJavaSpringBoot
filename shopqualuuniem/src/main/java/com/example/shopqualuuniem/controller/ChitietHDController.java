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

import com.example.shopqualuuniem.model.ChitietHD;
import com.example.shopqualuuniem.service.ChitietHDService;

@RestController
@RequestMapping("/ChitietHD")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class ChitietHDController {
    @Autowired
    private ChitietHDService ChitietHDService;

    @GetMapping("/getAllChitietHD")
    public List<ChitietHD> getAllChitietHD(){
        return ChitietHDService.findAll();
    }
    @GetMapping("/getById/{ma_chi_tiet}")
    public ResponseEntity<ChitietHD> getById(@PathVariable Integer ma_chi_tiet){
        Optional<ChitietHD> chitiet = ChitietHDService.findById(ma_chi_tiet);
        return chitiet.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public ChitietHD createRole(@RequestBody ChitietHD chitiet){
        return ChitietHDService.save(chitiet);
    }
    @PutMapping("/update/{ma_chi_tiet}")
    public ResponseEntity<ChitietHD> updateRole(@PathVariable Integer ma_chi_tiet, @RequestBody ChitietHD chitiet){
        if(ChitietHDService.findById(ma_chi_tiet).isPresent()){
            chitiet.setma_chi_tiet(ma_chi_tiet);
            return ResponseEntity.ok(ChitietHDService.save(chitiet ));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_chi_tiet}")
    public ResponseEntity<ChitietHD> deleteRole(@PathVariable Integer ma_chi_tiet){
        if(ChitietHDService.findById(ma_chi_tiet).isPresent()){
            ChitietHDService.deleteById(ma_chi_tiet);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

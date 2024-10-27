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

import com.example.shopqualuuniem.model.Giohang;
import com.example.shopqualuuniem.service.GiohangService;


@RestController
@RequestMapping("/Giohang")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class GiohangController {
    @Autowired
    private GiohangService GiohangService;

    @GetMapping("/getAllGiohang")
    public List<Giohang> getAllGiohang(){
        return GiohangService.findAll();
    }
    @GetMapping("/getById/{ma_gio_hang}")
    public ResponseEntity<Giohang> getById(@PathVariable Integer ma_gio_hang){
        Optional<Giohang> giohang = GiohangService.findById(ma_gio_hang);
        return giohang.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Giohang createRole(@RequestBody Giohang giohang){
        return GiohangService.save(giohang);
    }
    @PutMapping("/update/{ma_gio_hang}")
    public ResponseEntity<Giohang> updateRole(@PathVariable Integer ma_gio_hang, @RequestBody Giohang giohang){
        if(GiohangService.findById(ma_gio_hang).isPresent()){
            giohang.setma_gio_hang(ma_gio_hang);
            return ResponseEntity.ok(GiohangService.save(giohang));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_gio_hang}")
    public ResponseEntity<Giohang> deleteRole(@PathVariable Integer ma_gio_hang){
        if(GiohangService.findById(ma_gio_hang).isPresent()){
            GiohangService.deleteById(ma_gio_hang);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

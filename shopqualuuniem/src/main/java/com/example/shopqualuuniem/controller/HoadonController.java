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

import com.example.shopqualuuniem.model.Hoadon;
import com.example.shopqualuuniem.service.HoadonService;


@RestController
@RequestMapping("/Hoadon")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class HoadonController {
    @Autowired
    private HoadonService HoadonService;

    @GetMapping("/getAllHoadon")
    public List<Hoadon> getAllHoadon(){
        return HoadonService.findAll();
    }
    @GetMapping("/getById/{ma_hoa_don}")
    public ResponseEntity<Hoadon> getById(@PathVariable Integer ma_hoa_don){
        Optional<Hoadon> hoadon = HoadonService.findById(ma_hoa_don);
        return hoadon.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Hoadon createRole(@RequestBody Hoadon hoadon){
        return HoadonService.save(hoadon);
    }
    @PutMapping("/update/{ma_hoa_don}")
    public ResponseEntity<Hoadon> updateRole(@PathVariable Integer ma_hoa_don, @RequestBody Hoadon hoadon){
        if(HoadonService.findById(ma_hoa_don).isPresent()){
            hoadon.setma_hoa_don(ma_hoa_don);
            return ResponseEntity.ok(HoadonService.save(hoadon));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_hoa_don}")
    public ResponseEntity<Hoadon> deleteRole(@PathVariable Integer ma_hoa_don){
        if(HoadonService.findById(ma_hoa_don).isPresent()){
            HoadonService.deleteById(ma_hoa_don);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

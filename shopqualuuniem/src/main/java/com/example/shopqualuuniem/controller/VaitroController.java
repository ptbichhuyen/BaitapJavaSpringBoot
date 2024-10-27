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

import com.example.shopqualuuniem.model.Vaitro;
import com.example.shopqualuuniem.service.VaitroService;


@RestController
@RequestMapping("/Vaitro")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})
public class VaitroController {
    @Autowired
    private VaitroService VaitroService;

    @GetMapping("/getAllVaitro")
    public List<Vaitro> getAllVaitro(){
        return VaitroService.findAll();
    }
    @GetMapping("/getById/{ma_vai_tro}")
    public ResponseEntity<Vaitro> getById(@PathVariable Integer ma_vai_tro){
        Optional<Vaitro> vaitro = VaitroService.findById(ma_vai_tro);
        return vaitro.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Vaitro createRole(@RequestBody Vaitro vaitro){return VaitroService.save(vaitro);
    }
    @PutMapping("/update/{ma_vai_tro}")
    public ResponseEntity<Vaitro> updateRole(@PathVariable Integer ma_vai_tro, @RequestBody Vaitro vaitro){
        if(VaitroService.findById(ma_vai_tro).isPresent()){
            vaitro.setma_vai_tro(ma_vai_tro);
            return ResponseEntity.ok(VaitroService.save(vaitro));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{ma_vai_tro}")
    public ResponseEntity<Vaitro> deleteRole(@PathVariable Integer ma_vai_tro){
        if(VaitroService.findById(ma_vai_tro).isPresent()){
            VaitroService.deleteById(ma_vai_tro);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.ChitietHD;

@Repository
public interface ChitietHDRepos extends JpaRepository<ChitietHD,Integer>{
}

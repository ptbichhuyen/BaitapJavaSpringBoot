package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Hoadon;


@Repository
public interface HoadonRepos extends JpaRepository<Hoadon,Integer>{
}

package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Loai;


@Repository
public interface LoaiRepos extends JpaRepository<Loai,Integer>{
}

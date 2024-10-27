package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Sanpham;


@Repository
public interface SanphamRepos extends JpaRepository<Sanpham,Integer>{
}

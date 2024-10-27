package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Giohang;


@Repository
public interface GiohangRepos extends JpaRepository<Giohang,Integer> {
}

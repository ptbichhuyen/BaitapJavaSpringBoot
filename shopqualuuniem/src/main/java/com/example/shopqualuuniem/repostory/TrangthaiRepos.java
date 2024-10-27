package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Trangthai;


@Repository
public interface TrangthaiRepos extends JpaRepository<Trangthai,Integer> {
}

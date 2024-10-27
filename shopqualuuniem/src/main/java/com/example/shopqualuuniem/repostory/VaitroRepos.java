package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Vaitro;


@Repository
public interface VaitroRepos extends JpaRepository<Vaitro,Integer>{
}

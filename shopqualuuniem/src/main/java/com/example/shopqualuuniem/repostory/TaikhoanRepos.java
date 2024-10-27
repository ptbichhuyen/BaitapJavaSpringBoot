package com.example.shopqualuuniem.repostory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopqualuuniem.model.Taikhoan;


@Repository
public interface TaikhoanRepos extends JpaRepository<Taikhoan,Integer>{

}

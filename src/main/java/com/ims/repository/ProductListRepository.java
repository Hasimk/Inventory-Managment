package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.Product_List;

@Repository
public interface ProductListRepository extends JpaRepository<Product_List, Integer> {

}

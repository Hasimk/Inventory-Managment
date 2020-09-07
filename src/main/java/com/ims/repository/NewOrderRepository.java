package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.NewOrder;

@Repository
public interface NewOrderRepository extends JpaRepository<NewOrder, Integer> {

}

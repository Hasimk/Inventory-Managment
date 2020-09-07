package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.OrderList;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
	

}

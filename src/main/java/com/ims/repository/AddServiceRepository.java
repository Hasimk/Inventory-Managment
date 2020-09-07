package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.AddService;

@Repository
public interface AddServiceRepository extends JpaRepository<AddService, Integer> {

}

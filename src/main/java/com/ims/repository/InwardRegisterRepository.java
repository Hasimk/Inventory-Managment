package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.InwardRegister;

@Repository
public interface InwardRegisterRepository extends JpaRepository<InwardRegister, Integer> {

}

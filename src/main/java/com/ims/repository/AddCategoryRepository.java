package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.AddCategory;
@Repository
public interface AddCategoryRepository extends JpaRepository<AddCategory, Integer> {

}

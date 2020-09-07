package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AddCategory {
	
	@Id
	private Integer C_Id ;
	private String Category;  
	private String Category_Description;
	

}

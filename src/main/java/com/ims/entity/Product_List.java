package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product_List {
	@Id
	private Integer p_Id;
	private String Product_name;
	private String Category;
	private Double Purchase_price;
	private Double Sale_Price;
	private String Stock;
	private String Description;
	private String Image;
	private String View;
	
	

}

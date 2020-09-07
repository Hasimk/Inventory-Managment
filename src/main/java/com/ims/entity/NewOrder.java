package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class NewOrder {
	@Id
	private Integer Order_Id;
	private String Search_Poduct;
	private String Stock;
	private Double Price;
	private Integer Quantity;
	private Double Total; 
	private String Order_Status;

	
}

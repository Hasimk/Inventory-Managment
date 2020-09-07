package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class OrderList {
	
	@Id
	private Integer Invoice_ID;
	private String Customer_Name;
	private String Order_Date;
	private Double Total;
	private Double Paid;
	private Double Due;
	private String Payment_Type;
	

}

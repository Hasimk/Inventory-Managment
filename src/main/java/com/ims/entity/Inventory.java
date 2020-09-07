package com.ims.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Inventory {
	
	@Id
	private Integer Inventoryid;
	private String Project_Name; 
	private String Project_Description;
	private String Site_Name;
	
	
	

}

package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InwardRegister {
	@Id
	private Integer IRegister_Id;
	private String Item_Name;
	private String Item_Desc;
	private String Color;
	private String pNo_spec;
	private String make;
	private String unit;
	private Integer Quantity;

}

package com.ims.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddService {
	
	@Id
	private Integer  item_Id ;
	public Integer getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(Integer item_Id) {
		this.item_Id = item_Id;
	}
	public String getService_Name() {
		return Service_Name;
	}
	public void setService_Name(String service_Name) {
		Service_Name = service_Name;
	}
	public String getService_Description() {
		return Service_Description;
	}
	public void setService_Description(String service_Description) {
		Service_Description = service_Description;
	}
	public String getService_Type() {
		return Service_Type;
	}
	public void setService_Type(String service_Type) {
		Service_Type = service_Type;
	}
	private String Service_Name;
	private String Service_Description; 
	private String Service_Type;
	
	

}

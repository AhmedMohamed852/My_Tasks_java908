package com.item.model;

import java.sql.Date;

public class Item {
    private Long id;
    private String name;
    private double price;
    private int totalNumber;
   private Date manufacture_date;
   private Date expiry_date;
   private String description;
   private long id_item;
   
   
   
   
   
   
   private boolean hasDetails;

   public boolean isHasDetails() {
       return hasDetails;
   }
   public void setHasDetails(boolean hasDetails) {
       this.hasDetails = hasDetails;
   }
   

    public Item() { /* compiled code */ }

    public Item(Date manufacture_date, Date expiry_date,String description, long id_item) {
    	
    	this.manufacture_date = manufacture_date;
    	this.expiry_date = expiry_date;
    	this.description = description;
    	this.id_item = id_item;
    }
  

    public Item(Long id, String name, double price, int totalNumber) {
    	this.name = name;
    	this.id = id;
    	this.price = price;
    	this.totalNumber = totalNumber;
    	
    }

	public Date getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId_item() {
		return id_item;
	}

	public void setId_item(long id_item) {
		this.id_item = id_item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

}

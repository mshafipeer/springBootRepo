package com.myBuzzApp.springBoot.apis.productInventory.dailySales;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="DAILY_SALES_DETAILS")
public class DailySalesDetails {

	@Id  
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="PROD_ID")
	private int productId;
	
	@Column(name="PROD_REFRENCE_ID")
	private String productRefrence ;
	
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	@Column(name="UNIT_PRICE")
    private int unitPrice;
	
	@Column(name="QUANTITY")
    private int quantity;
	
	@Column(name="DISCOUNT_RATE")
    private double discount;
	
	@Column(name="TOTAL")
    private int total;
	
	@Column(name="CREATED_USER_ID")
    private String createdUserId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="NOTES")
	private String notes ;
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductRefrence() {
		return productRefrence;
	}

	public void setProductRefrence(String productRefrence) {
		this.productRefrence = productRefrence;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		this.deletionStatus = deletionStatus;
	}
    
	
}

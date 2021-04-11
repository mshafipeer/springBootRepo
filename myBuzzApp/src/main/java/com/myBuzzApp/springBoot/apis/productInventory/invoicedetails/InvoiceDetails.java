package com.myBuzzApp.springBoot.apis.productInventory.invoicedetails;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="INVOICE_DETAILS")
public class InvoiceDetails {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; 
	
	@Column(name="INVOICE_NUMBER")
	private String invoiceNumber;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName ;
	
	@Column(name="INVOICE_DETAILS")
	private String invoiceDetails;
	
	@Temporal(TemporalType.DATE)
	@Column(name="INVOICE_DATE")
	private Date invoiceDate;
	
	@Column(name="INVOICE_AMOUNT")
    private Double invoiceAmount;
	
	@Column(name="DELETION_STATUS")
    private String deletionStatus = "N";
	
    @Lob
    @Column(name="INVOICE_ATTACHMENT")
    private byte[] invoiceAttachment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(String invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getDeletionStatus() {
		return deletionStatus;
	}

	public void setDeletionStatus(String deletionStatus) {
		if(deletionStatus==null ||"".equalsIgnoreCase(deletionStatus)){
			this.deletionStatus = "N";
		}else {
			this.deletionStatus = deletionStatus;
		}
		
	}

	public byte[] getInvoiceAttachment() {
		return invoiceAttachment;
	}

	public void setInvoiceAttachment(byte[] invoiceAttachment) {
		this.invoiceAttachment = invoiceAttachment;
	}
  
    
    
}

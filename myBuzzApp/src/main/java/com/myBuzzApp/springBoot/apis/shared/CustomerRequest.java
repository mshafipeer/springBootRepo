package com.myBuzzApp.springBoot.apis.shared;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.myBuzzApp.springBoot.apis.productInventory.invoicedetails.InvoiceDetails;


@Service
public class CustomerRequest {
	
	public InvoiceDetails invoiceDetails;
	public ArrayList <InvoiceDetails> invoiceDetailsList;
	
	public CustomerRequest() {
		
	}

	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public ArrayList<InvoiceDetails> getInvoiceDetailsList() {
		return invoiceDetailsList;
	}

	public void setInvoiceDetailsList(ArrayList<InvoiceDetails> invoiceDetailsList) {
		this.invoiceDetailsList = invoiceDetailsList;
	}
}

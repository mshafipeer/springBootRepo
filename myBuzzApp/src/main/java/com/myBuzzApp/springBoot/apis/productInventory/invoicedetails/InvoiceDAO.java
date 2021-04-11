package com.myBuzzApp.springBoot.apis.productInventory.invoicedetails;

import org.springframework.data.repository.CrudRepository;


import com.myBuzzApp.springBoot.apis.productInventory.invoicedetails.InvoiceDetails;

public interface InvoiceDAO extends CrudRepository<InvoiceDetails,Integer> {
	
//	   @Query("SELECT t FROM InvoiceModel t where t.invoiceNumber = :invoiceNumber and t.deletionStatus ='N'" ) 
//	   InvoiceModel findByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber);
	   
	InvoiceDetails findByInvoiceNumber(String invoiceNumber);
	InvoiceDetails findById(int invoiceNumber);
	
	

}

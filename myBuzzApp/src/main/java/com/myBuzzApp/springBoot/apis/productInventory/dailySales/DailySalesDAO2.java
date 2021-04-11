package com.myBuzzApp.springBoot.apis.productInventory.dailySales;

import org.springframework.data.repository.CrudRepository;


public interface DailySalesDAO2 extends CrudRepository<DailySalesDetails,Integer> {
	
//	   @Query("SELECT t FROM InvoiceModel t where t.invoiceNumber = :invoiceNumber and t.deletionStatus ='N'" ) 
//	   InvoiceModel findByInvoiceNumber(@Param("invoiceNumber") String invoiceNumber);
	   
	DailySalesDetails findById(int id);
	

}

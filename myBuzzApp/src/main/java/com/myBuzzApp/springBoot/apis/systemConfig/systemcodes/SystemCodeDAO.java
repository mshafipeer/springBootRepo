package com.myBuzzApp.springBoot.apis.systemConfig.systemcodes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SystemCodeDAO  extends CrudRepository<SystemCodeDetails,Integer>{
	 
	@Query("select a from SystemCodeDetails a where a.systemCodeType = ?1 and a.deletionStatus = 'N'")
	SystemCodeDetails findBySystemCodeType(String systemCodeType); 
	
}
 
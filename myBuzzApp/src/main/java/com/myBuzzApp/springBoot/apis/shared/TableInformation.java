package com.myBuzzApp.springBoot.apis.shared;

public class TableInformation {
	
	/*
	create table PRODUCT_STOCK_DETAILS
	(
	  ID                    integer primary key,
	  PRODUCT_TYPE          integer ,
	  BRAND_ID              integer,
	  MODEL_ID				integer,
	  SPARE_PART_ID			integer,
	  QUALITY				VARCHAR(50),
	  RETAIL_BUY			integer,
	  RETAIL_SELL           integer DEFAULT 0,
	  WHOLESALE_BUY         integer DEFAULT 0,
	  WHOLESALE_SELL 		integer DEFAULT 0,
	  TOTAL_QUANTITY        integer DEFAULT 0,
	  SOLD_QUANTITY		    integer DEFAULT 0,
	  INVOICE_NUMBER		VARCHAR(50),
	  PROD_REFRENCE_ID      VARCHAR(50),
	  NOTES                 VARCHAR(250),
	  CREATED_USER_ID       VARCHAR(30) default 'admin',
	  CREATED_DATE          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  DELETION_STATUS       VARCHAR(1) default 'N' ,
	  UNIQUE KEY sparePartsUniqueConskey (BRAND_ID,MODEL_ID,SPARE_PART_ID,INVOICE_NUMBER,QUALITY)
	)
	
	
	create table GENERIC_MST_SYSTEM_CODE
	(
	  SYSTEM_CODE_ID        integer primary key not null,
	  SYSTEM_CODE_TYPE      VARCHAR(60) NOT NULL,
	  SYSTEM_CODE_DESC      VARCHAR(60) NOT NULL ,
	  DELETION_STATUS       VARCHAR(1) default 'N',
	   UNIQUE KEY sysCodeUniqueKey (SYSTEM_CODE_DESC)
	);

	create table GENERIC_DTL_SYSTEM_CODE
	(
	  SYSTEM_CODE_DTL_ID    integer primary key not null,
	  SYSTEM_CODE_ID        integer not null,
	  VALUE_CODE		    VARCHAR(60) NOT NULL,
	  VALUE			        VARCHAR(60) NOT NULL,
	  DELETION_STATUS       VARCHAR(1) default 'N',
	  UNIQUE KEY  sysCodeDtlUniqueKey(VALUE_CODE,VALUE),
	  FOREIGN KEY (SYSTEM_CODE_ID) REFERENCES GENERIC_MST_SYSTEM_CODE(SYSTEM_CODE_ID)
	);
	
	
	create table PRODUCT_BRAND
	(
	  ID integer primary key ,
	  BRAND_NAME            varchar(50) not null ,
	  BRAND_DESC            varchar(250),
	  CREATED_DATE          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  DELETION_STATUS       VARCHAR(1) default 'N',
	  UNIQUE KEY uniqueConskey (BRAND_NAME)
	)
	
	
	create table PRODUCT_MODEL
	(
	  ID                    integer primary key,
	  BRAND_ID         integer not null,
	  MODEL_NAME            VARCHAR(60) not null ,
	  MODEL_DESC            VARCHAR(250),
	  CREATED_DATE          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  DELETION_STATUS       VARCHAR(1) default 'N',
	   UNIQUE KEY bandmUniqueConskey (BRAND_ID,MODEL_NAME)
	)
	
	create table PRODUCT_PARTS_DETAILS
	(
	  ID                     integer primary key,
	  BRAND_ID               integer not null,
	  MODEL_ID         		 integer not null ,
	  SPARE_PART_NAME        VARCHAR(100),
	  SPARE_PART_DESC        VARCHAR(250),
	  CREATED_DATE           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  DELETION_STATUS        VARCHAR(1) default 'N',
	   UNIQUE KEY sparePartsUniqueConskey (BRAND_ID,MODEL_ID,SPARE_PART_NAME)
	);
	
	create table PRODUCT_STOCK_DETAILS
	(
	  ID                    integer primary key,
	  PRODUCT_TYPE          integer ,
	  BRAND_ID              integer,
	  MODEL_ID				integer,
	  SPARE_PART_ID			integer,
	  QUALITY				integer,
	  RETAIL_BUY			integer,
	  RETAIL_SELL           integer DEFAULT 0,
	  WHOLESALE_BUY         integer DEFAULT 0,
	  WHOLESALE_SELL 		integer DEFAULT 0,
	  TOTAL_QUANTITY        integer DEFAULT 0,
	  REMAINING_QUANTITY    integer DEFAULT 0,
	  INVOICE_ID			integer,
	  INVOICE_NUMBER		VARCHAR(50),
	  PROD_REFRENCE_ID      integer,
	  NOTES                 VARCHAR(250),
	  CREATED_USER_ID       VARCHAR(30) default 'admin',
	  CREATED_DATE          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  DELETION_STATUS       VARCHAR(1) default 'N'
	)
	
	create table invoice_details
	 (   
	     ID integer primary key,
	     INVOICE_NUMBER varchar(50), 
	     INVOICE_AMOUNT double precision,
	     INVOICE_DATE datetime, 
	     INVOICE_DETAILS varchar(255), 
	     SUPPLIER_NAME varchar(100),
	     DELETION_STATUS varchar(1) DEFAULT 'N',
	     CREATED_DATE   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	     INVOICE_ATTACHMENT BLOB,
	     UNIQUE KEY unique_email (INVOICE_NUMBER)
	 )
	 
	 
	CREATE OR REPLACE VIEW V_PRODUCT_STOCK_DETAILS AS
    (SELECT 
        stock.ID,
        stock.BRAND_ID,
        brand.BRAND_NAME,
        brand.BRAND_DESC,
        stock.MODEL_ID,
        model.MODEL_NAME,
        model.MODEL_DESC,
        stock.SPARE_PART_ID,
        parts.SPARE_PART_NAME,
        parts.SPARE_PART_DESC,
        stock.QUALITY,
        stock.RETAIL_BUY,
        stock.RETAIL_SELL,
        stock.WHOLESALE_BUY,
        stock.WHOLESALE_SELL,
        stock.TOTAL_QUANTITY,
        stock.REMAINING_QUANTITY,
        INVOICE.id INVOICE_ID,
        stock.INVOICE_NUMBER,
        stock.PROD_REFRENCE_ID
    FROM
        product_stock_details stock,
        PRODUCT_BRAND brand,
        PRODUCT_MODEL model,
        product_parts_details parts,
        invoice_details invoice
    WHERE
        stock.brand_id = brand.id
            AND stock.model_id = model.id
            AND stock.spare_part_id = parts.id
            AND stock.invoice_number = invoice.invoice_number
            AND stock.deletion_status = 'N');	
            
            
      create table DAILY_SALES_DETAILS
	(
	  ID                	integer primary key,
	  PROD_REFRENCE_ID      integer not null,
	  CUSTOMER_ID           integer,
	  UNIT_PRICE            integer not null,
	  QUANTITY              integer,
	  DISCOUNT_RATE         integer,
      TOTAL					integer,
	  CREATED_USER_ID       VARCHAR(30) default 'admin',
	  MODIFIED_USER_ID      VARCHAR(30) default 'admin',
	  CREATED_DATE          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  MODIFIED_DATE         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  NOTES                 VARCHAR(200),
	  DELETION_STATUS       VARCHAR(1) default 'N'
	);
	
	create table CUSTOMER_DETAILS
(
  ID             integer primary key not null,
  USER_NAME      VARCHAR(60) NOT NULL,
  USER_PASSWORD  VARCHAR(150) NOT NULL,
  FIRST_NAME     VARCHAR(20) NOT NULL ,
  MIDDLE_NAME    VARCHAR(20) NOT NULL,
  LAST_NAME     VARCHAR(20) NOT NULL ,
  CONTACT_NUMBER   VARCHAR(15) NOT NULL,
  EMAIL_ID       VARCHAR(30) NOT NULL ,
  CUSTOMER_AREA VARCHAR(20) NOT NULL,
  CUSTOMER_ADDRESS	VARCHAR(100) NOT NULL,
  CUSTOMER_TYPE  VARCHAR(20) NOT NULL ,
  CREATED_DATE  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  DELETION_STATUS  VARCHAR(1) default 'N'
);
	*/
}

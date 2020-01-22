package com.rafalazar.bootcamp.app.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="plazoFijoVip-clients")
public class PlazoFijoVip {
	
	@Id
	private String id;
	private String nameAccount;
	private String numAccount;
	private String dniOwner;
	private String status;
	private double monto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	public PlazoFijoVip() {
		
	}
	
	public PlazoFijoVip(String nameAccount,String numAccount,String dniOwner,String status,double monto){
		this.nameAccount = nameAccount;
		this.numAccount = numAccount;
		this.dniOwner = dniOwner;
		this.status = status;
		this.monto = monto;
	}

}

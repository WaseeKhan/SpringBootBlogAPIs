package com.lucifer.lab.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_roles")
public class Role {
	
	@Id
	private int id;
	
	private String name;
	

}

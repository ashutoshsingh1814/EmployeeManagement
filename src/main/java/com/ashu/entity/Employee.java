package com.ashu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="emptab")
public class Employee {
	
	@Id
	@Column(name="Code")

	private Integer empCode;
	
	@Column(name="Name")
	@NotBlank(message="Employee Name Cant be NULL")
	private String empName;
	
	@NotBlank(message = "DEPT Can't be NULL")
	@Column(name="Dept")
	private String empDept;
	
	

}

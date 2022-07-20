package com.lucifer.lab.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	
	private Integer categoryId;
	
	@NotEmpty
	@Size(min=2,max=100, message="Category Title must be min of 2 character and max of 100 character!")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=10,max=500, message="Category Description must be min of 10 character and max of 500 character!")
	private String categoryDescription;

}

package com.Soppify.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
   
	@Id
	private String productId;
	private String productName;
	private Double price;
	private String color;
	private String dimension;
	private String specification;
	private String manufacturer;
	private Integer quantity;
	@Min(value = 0, message = "min rating should be 0")
	@Max(value = 5, message = "max rating should be 5")
	@NotNull
//	@JsonIgnore
	private Double ratings = 0.0;
	@NotNull
//	@JsonIgnore
	private Integer numberOfRatings=0;
	@ManyToOne
	private Category category;
	
	
	
	
}

package com.Soppify.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Data
@Entity
@NoArgsConstructor
public class Category {
    @Id
	private String categoryId;
    @NotNull(message = "category name cannot be null")
    @NotBlank(message = "category name cannot be blank")
	private String categoryName;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	
	public Category( @NotNull(message = "category name cannot be null")
    @NotBlank(message = "category name cannot be blank")String catagoryName) {
		this.categoryName = catagoryName;
	}
	
}

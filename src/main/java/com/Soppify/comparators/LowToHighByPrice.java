package com.Soppify.comparators;

import java.util.Comparator;

import com.Soppify.models.Product;

public class LowToHighByPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getPrice()-o2.getPrice());
	}

	
	
}

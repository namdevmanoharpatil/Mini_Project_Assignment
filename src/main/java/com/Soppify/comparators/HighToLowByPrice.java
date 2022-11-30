package com.Soppify.Comparators;

import java.util.Comparator;

import com.Soppify.Entity.Product;

public class HighToLowByPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {

		return -(int)(o1.getPrice()-o2.getPrice());
	}

}

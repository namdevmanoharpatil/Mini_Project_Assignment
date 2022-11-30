package com.Soppify.Comparators;

import java.util.Comparator;
import com.Soppify.Entity.Product;

public class LowToHighByRatings implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {

		if(o1.getRatings()>o2.getRatings()) {
			return 1;
		}else if(o1.getRatings()<o2.getRatings()) {
			return -1;
		}
		return 0;
	}

	
	
}

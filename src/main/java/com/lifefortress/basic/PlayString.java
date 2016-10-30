package com.lifefortress.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PlayString {
	public static void main(String[] args) {
		BigDecimal data = BigDecimal.valueOf(1);
	    BigDecimal divisor = BigDecimal.valueOf(25);
	    System.out.println(data.divide(divisor, 0, RoundingMode.HALF_UP));
	    
	}
}

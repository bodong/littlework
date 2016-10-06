package com.lifefortress.basic;

import java.util.Scanner;

public class SignedPrimitiveType {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numberInput = input.nextInt();
		
		for (int i = 0; i < numberInput; i++) {
			
			try {
				long data = input.nextLong();
				System.out.println(data + " can be fitted in:");
				if(isByteRange(data)) {
					System.out.println("* byte");
				} 
				
				if(isShortRange(data)) {
					System.out.println("* short");
				}
				
				if(isIntRange(data)) {
					System.out.println("* int");
				}
				
				if(isLongRange(data)) {
					System.out.println("* long");
				}
				
			} catch (Exception e) {
				System.out.println(input.next() + " can't be fitted anywhere.");
			}
		}
		
	}
	
	private static boolean isLongRange(long n) {
		return n >= -9223372036854775808l && n <= 9223372036854775807l ;
	}
	
	
	private static boolean isIntRange(long n) {
		return n >= -2147483648 && n <= 2147483647l ;
	}
	
	private static boolean isShortRange(long n) {
		return n >= -32768 && n <= 32767 ;
	}

	private static boolean isByteRange(long n) {
		return n >= -128 && n <= 127;
	}
}

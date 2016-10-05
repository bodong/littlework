package com.lifefortress.basic;

import java.util.Scanner;

/**
 * given n = any number <br/>
 * when 1 < i <= 10  <br />
 * then print  N * i : result 
 * 
 * @author Sarwo Edi
 *
 */
public class SimpleLoop { 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n  = input.nextInt();
	
		for (int i = 1; i <= 10; i++) {
			System.out.println(String.format("%d x %d = %d ", n, i , (n*i)));
		}
		
	}
}

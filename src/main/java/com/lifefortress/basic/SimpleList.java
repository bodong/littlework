package com.lifefortress.basic;

import java.util.ArrayList;
import java.util.List;

public class SimpleList {
	
	public static void main(String[] args) {
		List<String> datas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			datas.add("data" + i);
		}
		
		System.out.println(datas.size());
		List<String> sub1 = datas.subList(0, 5);
		int i = 0;
		
		for (String string : sub1) {
			System.out.println("[" + i + "]" + string);
		}
		
		List<String> sub2 = datas.subList(5, 10);
		i = 0;
		for (String string : sub2) {
			System.out.println("sub 2 - [" + i + "]" + string);
		}
		
	}
}

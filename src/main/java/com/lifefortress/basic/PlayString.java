package com.lifefortress.basic;

public class PlayString {
	public static void main(String[] args) {
		String data = "U,D,S";
		String[] datas = data.split(",");
		for (String type : datas) {
			System.out.println(type);
		}
	}
}

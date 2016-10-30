package com.lifefortress.basic.enums;

public enum MyEnum {
	SUCCES("S"), FAILED("F"), ERROR("E");
	
	private String token;
	
	private MyEnum(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	
	public static MyEnum factory(String token) {
		if(token != null) {
			if(token.equals("S")) {
				return SUCCES;
			}
			if(token.equals("F")) {
				return FAILED;
			}
			if(token.equals("E")) {
				return ERROR;
			}
			
		}
		return null;
	}
	
	public static String getTokenEnum(MyEnum myEnum){
		return myEnum == null ? null : myEnum.getToken();
	}
}

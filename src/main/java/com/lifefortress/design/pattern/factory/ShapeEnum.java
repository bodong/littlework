package com.lifefortress.design.pattern.factory;

public enum ShapeEnum {
	RECTANGLE("Rectangle"), CIRCLE("Circle");
	
	private String code;
	private ShapeEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}

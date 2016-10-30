package com.lifefortress.design.pattern.factory;

public class FactoryApp {
	public static void main(String[] args) {
		Factory factory = new Factory();
		factory.getShape(ShapeEnum.RECTANGLE).draw();
		
		factory.getShape(ShapeEnum.CIRCLE).draw();
	}
}

package com.lifefortress.design.pattern.factory;


import com.lifefortress.design.pattern.domain.Circle;
import com.lifefortress.design.pattern.domain.Rectangle;
import com.lifefortress.design.pattern.domain.Shape;

public class Factory {
	
	public Shape getShape(ShapeEnum shapeEnum) {
		Shape shape = null;
		switch (shapeEnum) {
		case RECTANGLE:
			shape = new Rectangle();
			break;

		case CIRCLE:
			shape = new Circle();
			break;
			
		default:
			break;
		}
		
		return shape;
	}
}

package com.lifefortress.design.pattern.strategy;

import com.lifefortress.design.pattern.domain.Shape;

public class Context {
	private Shape shape;
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public void draw() {
		shape.draw();
	}
	
}

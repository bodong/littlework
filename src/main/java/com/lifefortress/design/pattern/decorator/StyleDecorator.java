package com.lifefortress.design.pattern.decorator;

import com.lifefortress.design.pattern.domain.Shape;

public class StyleDecorator extends ShapeDecorator {

	public StyleDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
		super.draw();
		doSomeStyle();
	}

	private void doSomeStyle() {
		System.out.println("Do some style");
	}

}

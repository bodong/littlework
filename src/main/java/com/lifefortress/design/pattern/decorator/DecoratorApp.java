package com.lifefortress.design.pattern.decorator;

import com.lifefortress.design.pattern.domain.Circle;
import com.lifefortress.design.pattern.domain.Rectangle;
import com.lifefortress.design.pattern.domain.Shape;

public class DecoratorApp {
	
	public static void main(String[] args) {
		
		Shape r = new Rectangle();
		
		Shape decor = new StyleDecorator(r);
		decor.draw();
		
		Shape c = new Circle();
		decor = new StyleDecorator(c);
		decor.draw();
	}
	
}

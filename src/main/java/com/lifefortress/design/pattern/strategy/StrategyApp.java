package com.lifefortress.design.pattern.strategy;

import com.lifefortress.design.pattern.domain.Circle;
import com.lifefortress.design.pattern.domain.Rectangle;
import com.lifefortress.design.pattern.domain.Shape;

public class StrategyApp {
	public static void main(String[] args) {
		Context context = new Context();
		
		Shape r = new Rectangle();
		context.setShape(r);
		context.draw();
		
		
		Shape c = new Circle();
		context.setShape(c);
		context.draw();
		
		
	}
}

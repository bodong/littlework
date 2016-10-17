package com.lifefortress.basic;

public class FlowControl {
	public static void main(String[] args) {
		FlowControl f = new FlowControl();
		
		long s1 = System.currentTimeMillis();
		
		for (int i = 0 ; i < 1000000; i++) {
			Test1 t1 = f.new Test1();
			t1.hashCode();
		}
		
		long c1 = System.currentTimeMillis() - s1;
		System.out.println(c1);
		
		long s2 = System.currentTimeMillis();
		
		for (int i = 0 ; i < 1000000; i++) {
			Test2 t2 = f.new Test2();
			t2.hashCode();

		}
		
		long c2 = System.currentTimeMillis() - s2;
		System.out.println(c2);
		
	}

	class Test1 {
		public int value;

		public int hashCode() {
			return 42;
		}
	}

	class Test2 {
		public int value;

		public int hashcode() {
			return (int) (value ^ 5);
		}
	}
}

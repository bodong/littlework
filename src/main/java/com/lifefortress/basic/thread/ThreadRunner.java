package com.lifefortress.basic.thread;

public class ThreadRunner {
	public static void main(String[] args) throws InterruptedException {
		QueueStat qStat = new QueueStat();
		
		Thread producer = new Thread(new Producer(qStat));
		producer.start();
		
		Thread.sleep(10);
		
		Thread consumer = new Thread(new Consumer(qStat));
		consumer.start();
		
		
	}
}

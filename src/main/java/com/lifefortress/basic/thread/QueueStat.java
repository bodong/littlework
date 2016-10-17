package com.lifefortress.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueStat {
	private int count = 0;
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
	
	public synchronized void produce() {
		while(true){
			try {
				wait(100);
			} catch (InterruptedException e) {
				if(queue.isEmpty()) {
					count ++;
					try {
						Thread.sleep(4000); //sleep for 4 seconds
					} catch (InterruptedException e2) {
						queue.add(count);
						System.out.println(Thread.currentThread().getName() + " produced " + count);
						notifyAll();
					}
				}
			}
		}
	}
	
	public synchronized void consume() {
		while(true) {
			try {
				wait(100);
			} catch (InterruptedException e) {
				if(!queue.isEmpty()) {
					Integer consumed = queue.remove();
					System.out.println(Thread.currentThread().getName() + " consumed " + consumed);
					notifyAll();
				}
			}
		}
	}
	
}

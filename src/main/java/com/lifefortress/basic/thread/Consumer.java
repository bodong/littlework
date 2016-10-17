package com.lifefortress.basic.thread;

public class Consumer implements Runnable {

	private QueueStat qStat;
	
	public Consumer(QueueStat qStat) {
		this.qStat = qStat;
	}
	
	@Override
	public void run() {
		qStat.consume();
	}

}

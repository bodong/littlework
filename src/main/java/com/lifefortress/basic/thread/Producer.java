package com.lifefortress.basic.thread;

public class Producer implements Runnable{

	private QueueStat qStat;
	
	public Producer(QueueStat qStat) {
		this.qStat = qStat;
	}
	
	@Override
	public void run() {
		qStat.produce();
	}

}

package de.hska.iwii.monotonechain;

public class Timer {

	private long startTime = 0;
	private long endTime = 0;
	private long runTime = 0;
	
	public void start() {
		this.startTime = System.nanoTime();
	}
	
	
	public void stop() {
		long endTime = System.nanoTime();
		this.runTime = endTime - this.startTime;
	}
	
	public long getRunTime() {
		return this.runTime;
	}
	
}

package de.kellertobias.hs.algolab.convexhull;

public class Timer {
	
	private long startTime = 0;
	private long runTime = 0;
	
	
	public void reset() {
		this.startTime = 0;
		this.runTime = 0;
	}
	
	public void start() {
		this.reset();
		this.startTime = System.nanoTime();
	}

	public void stop() {
		this.runTime = System.nanoTime() - this.startTime;
	}
	
	public long getRuntime() {
		return this.runTime;
	}
	
	
}

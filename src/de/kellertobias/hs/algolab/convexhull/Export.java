package de.kellertobias.hs.algolab.convexhull;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.kellertobias.hs.algolab.dataset.Dataset;

/**
 * Export given information to a file
 * 
 * @author Michael Klein
 *
 */
public class Export {
	
	private String filename;
	private String output = "";
	
	/**
	 * 
	 * @param filename File, the information will be stored
	 */
	public Export(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Add the Points of a dataset to the file 
	 * @param dataset
	 */
	public void addPoints(List<Point> dataset) {
		for (Point point : dataset) {
			this.output+= (point.getX()+","+point.getY()+";\n");
		}
	}
	
	/**
	 * add the complete dataset in a formated way to the file
	 * @param dataset
	 */
	public void addDataset(Dataset dataset) {
		this.output+="::ppl-dataset::\n";
		this.addPoints(dataset.getPoints());
	}
	
	/**
	 * add the points of the convex-hull to the file
	 * @param hull
	 */
	public void addHull(List<Point> hull) {
		this.output+="::ppl-hull::\n";
		this.addPoints(hull);
	}
	
	/**
	 * add the benchmark-results to the file
	 * 
	 * @param amount the amount of points
	 * @param tmp the runtime of the algorithm
	 */
	public void addBenchmark(int amount, double tmp) {
		this.output+= amount+","+tmp+";\n";
	}
	
	
	/**
	 * store the information to the filesystem
	 */
	public void store() {
		
		try {
			FileWriter writer = new FileWriter(this.filename);
			writer.write(this.output);
			writer.close();
		} catch (IOException e) {
			System.err.println("Export failed." + e);
		}
	}
}

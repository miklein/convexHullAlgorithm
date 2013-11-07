package de.kellertobias.hs.algolab.convexhull;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.kellertobias.hs.algolab.dataset.Dataset;

public class Export {
	
	private String filename;
	private String output = "";
	
	public Export(String filename) {
		this.filename = filename;
	}
	
	public void addPoints(List<Point> dataset) {
		for (Point point : dataset) {
			this.output+= (point.getX()+","+point.getY()+";\n");
		}
	}
	
	
	public void addDataset(Dataset dataset) {
		this.output+="::ppl-dataset::\n";
		this.addPoints(dataset.getPoints());
	}
	
	public void addHull(List<Point> hull) {
		this.output+="::ppl-hull::\n";
		this.addPoints(hull);
	}
	
	public void addBenchmark(int amount, long runtime) {
		this.output+= amount+","+runtime+";\n";
	}
	
	
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

package jp.dip.sys1.market.statistics.graph;

import java.io.File;
import java.util.List;

import jp.dip.sys1.market.statistics.data.Sales;

public interface SalesGraph {
	public void createChart(File outputDir, String prefix, List<Sales> sales); 
}

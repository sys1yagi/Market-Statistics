package jp.dip.sys1.market.statistics.graph;

import java.io.File;
import java.util.List;

import jp.dip.sys1.market.statistics.Sales;

public class MonthlyBarGraph implements SalesGraph {
	private MonthlyBarGraph This() {
		return this;
	}

	@Override
	public void createChart(File outputDir, String prefix, List<Sales> sales) {
		// TODO Auto-generated method stub

	}
}

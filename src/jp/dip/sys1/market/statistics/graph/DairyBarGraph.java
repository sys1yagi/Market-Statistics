package jp.dip.sys1.market.statistics.graph;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import jp.dip.sys1.market.statistics.Sales;

public class DairyBarGraph implements SalesGraph {

	@Override
	public void createChart(File outputDir, String prefix, List<Sales> sales) {
		if (!outputDir.exists()) {
			outputDir.mkdirs();
		}
		Map<String, List<Sales>> packages = dispatch(sales);

		for (Entry<String, List<Sales>> entry : packages.entrySet()) {
			List<Sales> tmp = new ArrayList<Sales>(entry.getValue());
			if (tmp.isEmpty()) {
				continue;
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Integer> counts = new TreeMap<String, Integer>();
			for (Sales s : tmp) {
				String key = format.format(s.getOrderChargedDate());
				Integer count = counts.get(key);
				if (count == null) {
					counts.put(key, 1);
				} else {
					counts.put(key, 1 + count);
				}
			}
			ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			for (Entry<String, Integer> e : counts.entrySet()) {
				data.addValue(e.getValue(), "日別売上", e.getKey());
				// log
				System.out.println(e.getKey() + ":" + e.getValue());
			}
			JFreeChart chart = ChartFactory.createBarChart("dairy sales: "
					+ tmp.get(0).getProductTitle() + "/"
					+ tmp.get(0).getProductID(), "dairy", "count", data,
					PlotOrientation.HORIZONTAL, true, false, false);
			try {
				ChartUtilities.saveChartAsPNG(new File(outputDir, prefix + "-"
						+ tmp.get(0).getProductID() + ".png"), chart, 800, 600);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(entry.getKey() + ":" + tmp.size());
			System.out.println(tmp.get(0));
		}
	}

	private Map<String, List<Sales>> dispatch(List<Sales> sales) {
		Map<String, List<Sales>> map = new HashMap<String, List<Sales>>();
		for (Sales s : sales) {
			List<Sales> ss = map.get(s.getProductID());
			if (ss == null) {
				ss = new ArrayList<Sales>();
				ss.add(s);
				map.put(s.getProductID(), ss);
			} else {
				ss.add(s);
			}
		}
		return map;
	}
}

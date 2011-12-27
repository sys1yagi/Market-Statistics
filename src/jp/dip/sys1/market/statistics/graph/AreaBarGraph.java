package jp.dip.sys1.market.statistics.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import jp.dip.sys1.market.statistics.data.Sales;

public class AreaBarGraph implements SalesGraph {
    @Override
    public void createChart(File outputDir, String prefix, List<Sales> sales) {
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        Map<String, List<Sales>> products = Util.dispatchProductId(sales);
        for (Entry<String, List<Sales>> entry : products.entrySet()) {

            List<Sales> productSales = entry.getValue();
            if (productSales.isEmpty()) {
                continue;
            }
            System.out.println("product:" + entry.getKey() + " size:" + productSales.size());
            // dispatch area
            Map<String, List<Sales>> areas = Util.dispachArea(productSales);
            System.out.println("ares count:" + areas.size());
            // グラフの作成
            ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for (Entry<String, List<Sales>> e : areas.entrySet()) {
                data.addValue(e.getValue().size(), "地域別個数", e.getKey());
                // log
            }
            //@formatter:off
            JFreeChart chart = ChartFactory.createBarChart(
                    "地域別販売個数: " + productSales.get(0).getProductTitle() + "/" + productSales.get(0).getProductID(), "" +
            		"地域別",
            		"個数",
            		data, 
            		PlotOrientation.HORIZONTAL, 
            		true, false, false);
            //@formatter:on
            chart.setAntiAlias(true);
            chart.setTextAntiAlias(true);
            
            try {
                
                ChartUtilities.saveChartAsPNG(new File(outputDir, prefix + "-" + productSales.get(0).getProductID() + ".png"), chart, 600, 100+areas.size()*20);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

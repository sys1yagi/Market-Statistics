
package jp.dip.sys1.market.statistics;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.dip.sys1.market.statistics.graph.DairyBarGraph;
import jp.dip.sys1.market.statistics.graph.MonthlyBarGraph;
import jp.dip.sys1.market.statistics.graph.MonthlyLineGraph;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Settings settings = new Settings();
            File salesReportDirectory = new File(settings.getSalesReportDirectory());
            List<Sales> sales = new ArrayList<Sales>();
            File[] csv = salesReportDirectory.listFiles(new CsvFileFilter());
            if(csv == null){
            	System.out.println("CSV file was not found! directory = " + settings.getSalesReportDirectory());
            	return;
            }
            for (File salesReport : csv) {
                sales.addAll(SalesReader.readCSV(salesReport));
            }
           
            //new DairyBarGraph().createChart(new File("dairy"), "dairy", sales);
            new MonthlyBarGraph().createChart(new File("monthly"), "monthly_bar", sales);
            new MonthlyLineGraph().createChart(new File("monthly"), "monthly_line", sales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class CsvFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name != null && name.endsWith(".csv");
        }
    }
}

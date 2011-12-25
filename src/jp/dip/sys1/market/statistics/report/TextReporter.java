package jp.dip.sys1.market.statistics.report;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author sys1yagi
 *
 */
import jp.dip.sys1.market.statistics.data.Sales;
import jp.dip.sys1.market.statistics.data.Settings;
public class TextReporter implements Reporter {

    @Override
    public void report(Settings settings, List<Sales> sales) throws IOException {
        File outputDir = new File(settings.getOutputDirectory());
        System.out.println("text!");
        
//        new DairyBarGraph().createChart(new File(outputDir, "dairy"), "dairy", sales);
//        new MonthlyBarGraph().createChart(new File(outputDir, "monthly"), "monthly_bar", sales);
//        new MonthlyLineGraph().createChart(new File(outputDir, "monthly"), "monthly_line", sales);
    }
}

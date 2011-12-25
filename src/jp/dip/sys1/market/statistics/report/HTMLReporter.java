package jp.dip.sys1.market.statistics.report;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jp.dip.sys1.market.statistics.data.Sales;
import jp.dip.sys1.market.statistics.data.Settings;
import jp.dip.sys1.market.statistics.graph.DairyBarGraph;
import jp.dip.sys1.market.statistics.graph.MonthlyBarGraph;
import jp.dip.sys1.market.statistics.graph.MonthlyLineGraph;

/**
 * 
 * @author sys1yagi
 *
 */
public class HTMLReporter implements Reporter {
    @Override
    public void report(Settings settings, List<Sales> sales) throws IOException {
        File outputDir = new File(settings.getOutputDirectory());
        new DairyBarGraph().createChart(new File(outputDir, "dairy"), "dairy", sales);
        new MonthlyBarGraph().createChart(new File(outputDir, "monthly"), "monthly_bar", sales);
        new MonthlyLineGraph().createChart(new File(outputDir, "monthly"), "monthly_line", sales);
    }
}


package jp.dip.sys1.market.statistics;

import java.io.IOException;
import java.util.List;
import jp.dip.sys1.market.statistics.data.Sales;
import jp.dip.sys1.market.statistics.data.SalesDataLoader;
import jp.dip.sys1.market.statistics.data.SalesDataLoaderFactory;
import jp.dip.sys1.market.statistics.data.Settings;
import jp.dip.sys1.market.statistics.report.Reporter;
import jp.dip.sys1.market.statistics.report.ReporterFactory;

/**
 * 
 * @author sys1yagi
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Settings settings = new Settings();
            SalesDataLoader loader = SalesDataLoaderFactory.createLoader(settings); 
            List<Sales> sales = loader.getAllSalesData(settings); 
            Reporter reporter = ReporterFactory.createReporter(settings);
            reporter.report(settings, sales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}

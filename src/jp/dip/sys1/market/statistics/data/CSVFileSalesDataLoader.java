package jp.dip.sys1.market.statistics.data;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVFileSalesDataLoader implements SalesDataLoader {
    private CSVFileSalesDataLoader This() {
        return this;
    }

    @Override
    public List<Sales> getAllSalesData(Settings settings) throws IOException{
        File salesReportDirectory = new File(settings.getSalesReportDirectory());
        List<Sales> sales = new ArrayList<Sales>();
        File[] csv = salesReportDirectory.listFiles(new CsvFileFilter());
        if(csv == null){
            throw new RuntimeException("CSV file was not found! directory = " + settings.getSalesReportDirectory());
        }
        for (File salesReport : csv) {
            sales.addAll(SalesReader.readCSV(salesReport));
        }
        return sales;
    }
    static class CsvFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name != null && name.endsWith(".csv");
        }
    }
}

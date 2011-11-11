
package jp.dip.sys1.market.statistics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final String SETTINGS_PROPERTIES_PATH = "settings.properties";

    private static final String SALES_REPORT_KEY = "sales_report_directory";

    private String salesReportDirectory;

    public Settings() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(SETTINGS_PROPERTIES_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("I need properties file. %s",
                    SETTINGS_PROPERTIES_PATH), e);
        } catch (IOException e) {
            throw new RuntimeException("failed to load the properties file", e);
        }

        salesReportDirectory = properties.getProperty(SALES_REPORT_KEY, null);
        if (salesReportDirectory == null)
            throw new RuntimeException(String.format("not found '%s' key in properties",
                    SALES_REPORT_KEY));
    }

    public String getSalesReportDirectory() {
        return salesReportDirectory;
    }
}

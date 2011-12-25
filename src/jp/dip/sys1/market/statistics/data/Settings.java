package jp.dip.sys1.market.statistics.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author tomorrowkey
 * 
 */
public class Settings {

    private static final String SETTINGS_PROPERTIES_PATH = "settings.properties";

    //property keys
    private static final String KEY_SALES_REPORT = "sales_report_directory";
    private static final String KEY_OUTPUT_DIRECTORY = "output_directory";
    private static final String KEY_OUTPUT_FORMAT = "output_format";
    
    
    public enum OUTPUT_FORMAT{
        HTML,
        TEXT,
    }
    
    private Properties mProperties;

    public Settings() {
        mProperties = new Properties();
        try {
            mProperties.load(new FileInputStream(SETTINGS_PROPERTIES_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("I need properties file. %s", SETTINGS_PROPERTIES_PATH), e);
        } catch (IOException e) {
            throw new RuntimeException("failed to load the properties file", e);
        }

        // 必須値チェック
        checkDependedKey(KEY_SALES_REPORT);
        checkDependedKey(KEY_OUTPUT_DIRECTORY);
    }

    private void checkDependedKey(String key) {
        if (!mProperties.containsKey(key)) {
            throw new RuntimeException(String.format("not found '%s' key in properties", key));
        }
    }

    public String getSalesReportDirectory() {
        return mProperties.getProperty(KEY_SALES_REPORT, null);
    }
    public String getOutputDirectory(){
        return mProperties.getProperty(KEY_OUTPUT_DIRECTORY, null);
    }
    public OUTPUT_FORMAT getOutputFormat(){
        OUTPUT_FORMAT format = OUTPUT_FORMAT.valueOf(mProperties.getProperty(KEY_OUTPUT_FORMAT));
        if(format == null){
            format = OUTPUT_FORMAT.TEXT;
        }
        return format;
    }
    
}

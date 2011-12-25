package jp.dip.sys1.market.statistics.report;

import jp.dip.sys1.market.statistics.data.Settings;
import jp.dip.sys1.market.statistics.data.Settings.OUTPUT_FORMAT;

/**
 * 
 * @author sys1yagi
 *
 */
public class ReporterFactory {
    
    public static Reporter createReporter(Settings settings){
        
        OUTPUT_FORMAT format = settings.getOutputFormat();
        if(format != null){
            switch(format){
            case HTML:
                return new HTMLReporter();
            case TEXT:
                return new TextReporter();
            }
        }
        return new TextReporter();
    }
}

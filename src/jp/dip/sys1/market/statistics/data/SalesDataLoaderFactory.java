package jp.dip.sys1.market.statistics.data;

/**
 * 
 * @author sys1yagi
 *
 */
public class SalesDataLoaderFactory {   
    public static SalesDataLoader createLoader(Settings settings){
        
        //TODO add settings

        return new CSVFileSalesDataLoader();
    }
}

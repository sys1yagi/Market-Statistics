package jp.dip.sys1.market.statistics.data;


public class SalesDataLoaderFactory {
    private SalesDataLoaderFactory This() {
        return this;
    }
    
    public static SalesDataLoader createLoader(Settings settings){
        
        //TODO add settings

        return new CSVFileSalesDataLoader();
    }
}

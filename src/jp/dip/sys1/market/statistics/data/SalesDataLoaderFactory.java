package jp.dip.sys1.market.statistics.data;

/**
 * データの読み込むSalesDataLoaderを生成するファクトリクラスです
 * @author sys1yagi
 *
 */
public class SalesDataLoaderFactory {   
    
    /**
     * settings.propertiesに指定したloader_typeの値によって返却するSalesLoaderが異なります
     * @param settings
     * @return
     */
    public static SalesDataLoader createLoader(Settings settings){
        
        //TODO add settings

        return new CSVFileSalesDataLoader();
    }
}

package jp.dip.sys1.market.statistics.data;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author sys1yagi
 *
 */
public interface SalesDataLoader {
    
    public List<Sales> getAllSalesData(Settings settings) throws IOException;
}

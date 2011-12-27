package jp.dip.sys1.market.statistics.data;

import java.io.IOException;
import java.util.List;

public class DatabaseSalesDataLoader implements SalesDataLoader {
    private DatabaseSalesDataLoader This() {
        return this;
    }

    @Override
    public List<Sales> getAllSalesData(Settings settings) throws IOException {
        return null;
    }
}

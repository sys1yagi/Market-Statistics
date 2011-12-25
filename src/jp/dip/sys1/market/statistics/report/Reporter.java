package jp.dip.sys1.market.statistics.report;

import java.io.IOException;
import java.util.List;

import jp.dip.sys1.market.statistics.data.Sales;
import jp.dip.sys1.market.statistics.data.Settings;

/**
 * レポートファイルを作成するインタフェース
 * @author sys1yagi
 *
 */
public interface Reporter {
    public void report(Settings settings, List<Sales> sales) throws IOException;
}

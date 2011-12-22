package jp.dip.sys1.market.statistics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.dip.sys1.market.statistics.Sales;

public class Util {
	/**
	 * Salesをプロダクト毎に振り分け、Mapを作成する
	 * @param sales
	 * @return
	 */
	public static Map<String, List<Sales>> dispatchProductId(List<Sales> sales) {
		Map<String, List<Sales>> map = new HashMap<String, List<Sales>>();
		for (Sales s : sales) {
			List<Sales> ss = map.get(s.getProductID());
			if (ss == null) {
				ss = new ArrayList<Sales>();
				ss.add(s);
				map.put(s.getProductID(), ss);
			} else {
				ss.add(s);
			}
		}
		return map;
	}
}

package jp.dip.sys1.market.statistics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.dip.sys1.market.statistics.data.Sales;

/**
 * 
 * @author sys1yagi
 *
 */
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
	
	/**
	 * Salesデータを販売地域毎に振り分ける
	 * @param sales
	 * @return
	 */
	public static Map<String,List<Sales>> dispachArea(List<Sales> sales){
	    Map<String, List<Sales>> map = new HashMap<String, List<Sales>>();
	    System.out.println("dispatchArea:" + sales.size());
        for (Sales s : sales) {
            List<Sales> ss = map.get(s.getStateOfBuyer());
            if (ss == null) {
                ss = new ArrayList<Sales>();
                ss.add(s);
                map.put(s.getStateOfBuyer(), ss);
            } else {
                ss.add(s);
            }
        }
        return map;
	}
}

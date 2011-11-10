package jp.dip.sys1.market.statistics;

import java.io.File;
import java.util.List;

import jp.dip.sys1.market.statistics.graph.DairyBarGraph;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			List<Sales> sales = SalesReader.readCSV(new File("sales_report_2011_10.csv"));
			System.out.println("count:" + sales.size());
			new DairyBarGraph().createChart(new File("dairy"), "dairy", sales);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
}

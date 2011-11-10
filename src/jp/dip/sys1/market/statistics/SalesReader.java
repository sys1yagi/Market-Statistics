package jp.dip.sys1.market.statistics;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.StrNotNullOrEmpty;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.util.CSVContext;

public class SalesReader {

	private final static CellProcessor DIRECTORY_VALUE = new StringCellProcessor() {
		@Override
		public Object execute(Object value, CSVContext context) {
			return value;
		}
	};
	static final CellProcessor[] salesProcessors = new CellProcessor[] {
			new StrNotNullOrEmpty(), new ParseDate("yyyy-MM-dd"),
			new ParseLong(), new StrNotNullOrEmpty(),
			new ParseDate("yyyy-MM-dd"), new StrNotNullOrEmpty(),
			new StrNotNullOrEmpty(), new StrNotNullOrEmpty(),
			new StrNotNullOrEmpty(), new ParseDouble(), new ParseDouble(),
			new ParseDouble(), new StrNotNullOrEmpty(), DIRECTORY_VALUE,
			DIRECTORY_VALUE, DIRECTORY_VALUE, DIRECTORY_VALUE, DIRECTORY_VALUE,
			DIRECTORY_VALUE };

	public static List<Sales> readCSV(File csv) throws IOException {
		List<Sales> sales = new ArrayList<Sales>();
		ICsvBeanReader reader = new CsvBeanReader(new FileReader(csv),
				CsvPreference.EXCEL_PREFERENCE);
		// ヘッダ読み捨て
		String[] headers = reader.getCSVHeader(true);
		headers = new String[] { "OrderNumber", "OrderChargedDate",
				"OrderChargedTimestamp", "FinancialStatus", "PayoutDate",
				"DeviceModel", "ProductTitle", "ProductID", "CurrencyOfSale",
				"ItemPrice", "TaxesCollected", "ChargedAmount",
				"MerchantCurrency", "EstimatedFXRate", "MerchantReceives",
				"CityOfBuyer", "StateOfBuyer", "PostalCodeOfBuyer",
				"CountryOfBuyer", };
		Sales s = null;
		while ((s = reader.read(Sales.class, headers, salesProcessors)) != null) {
			sales.add(s);
		}

		return sales;
	}
}

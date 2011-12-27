package jp.dip.sys1.market.statistics.data;

import java.util.Date;

/**
 * 売上データ。一個の販売データを表す
 * 
 * @author sys1yagi
 * 
 */
public class Sales {

    String mOrderNumber;
    Date mOrderChargedDate;
    long mOrderChargedTimestamp;
    String mFinancialStatus;
    Date mPayoutDate;
    String mDeviceModel;
    String mProductTitle;
    String mProductID;
    String mCurrencyOfSale;
    double mItemPrice;
    double mTaxesCollected;
    double mChargedAmount;
    String mMerchantCurrency;
    String mEstimatedFXRate;
    String mMerchantReceives;
    String mCityOfBuyer;
    String mStateOfBuyer;
    String mPostalCodeOfBuyer;
    String mCountryOfBuyer;

    public String getOrderNumber() {
        return mOrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        mOrderNumber = orderNumber;
    }

    public Date getOrderChargedDate() {
        return mOrderChargedDate;
    }

    public void setOrderChargedDate(Date orderChargedDate) {
        mOrderChargedDate = orderChargedDate;
    }

    public long getOrderChargedTimestamp() {
        return mOrderChargedTimestamp;
    }

    public void setOrderChargedTimestamp(long orderChargedTimestamp) {
        mOrderChargedTimestamp = orderChargedTimestamp;
    }

    public String getFinancialStatus() {
        return mFinancialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        mFinancialStatus = financialStatus;
    }

    public Date getPayoutDate() {
        return mPayoutDate;
    }

    public void setPayoutDate(Date payoutDate) {
        mPayoutDate = payoutDate;
    }

    public String getDeviceModel() {
        return mDeviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        mDeviceModel = deviceModel;
    }

    public String getProductTitle() {
        return mProductTitle;
    }

    public void setProductTitle(String productTitle) {
        mProductTitle = productTitle;
    }

    public String getProductID() {
        return mProductID;
    }

    public void setProductID(String productID) {
        mProductID = productID;
    }

    public String getCurrencyOfSale() {
        return mCurrencyOfSale;
    }

    public void setCurrencyOfSale(String currencyOfSale) {
        mCurrencyOfSale = currencyOfSale;
    }

    public double getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        mItemPrice = itemPrice;
    }

    public double getTaxesCollected() {
        return mTaxesCollected;
    }

    public void setTaxesCollected(double taxesCollected) {
        mTaxesCollected = taxesCollected;
    }

    public double getChargedAmount() {
        return mChargedAmount;
    }

    public void setChargedAmount(double chargedAmount) {
        mChargedAmount = chargedAmount;
    }

    public String getMerchantCurrency() {
        return mMerchantCurrency;
    }

    public void setMerchantCurrency(String merchantCurrency) {
        mMerchantCurrency = merchantCurrency;
    }

    public String getEstimatedFXRate() {
        return mEstimatedFXRate;
    }

    public void setEstimatedFXRate(String estimatedFXRate) {
        mEstimatedFXRate = estimatedFXRate;
    }

    public String getMerchantReceives() {
        return mMerchantReceives;
    }

    public void setMerchantReceives(String merchantReceives) {
        mMerchantReceives = merchantReceives;
    }

    public String getCityOfBuyer() {
        return mCityOfBuyer;
    }

    public void setCityOfBuyer(String cityOfBuyer) {
        mCityOfBuyer = cityOfBuyer;
    }

    public String getStateOfBuyer() {
        return mStateOfBuyer;
    }

    public void setStateOfBuyer(String stateOfBuyer) {
        mStateOfBuyer = stateOfBuyer;
    }

    public String getPostalCodeOfBuyer() {
        return mPostalCodeOfBuyer;
    }

    public void setPostalCodeOfBuyer(String postalCodeOfBuyer) {
        mPostalCodeOfBuyer = postalCodeOfBuyer;
    }

    public String getCountryOfBuyer() {
        return mCountryOfBuyer;
    }

    public void setCountryOfBuyer(String countryOfBuyer) {
        mCountryOfBuyer = countryOfBuyer;
    }

    @Override
    public String toString() {
        return "Sales [mOrderNumber\":" + mOrderNumber + ", \"mOrderChargedDate\":" + mOrderChargedDate + ", \"mOrderChargedTimestamp\":" + mOrderChargedTimestamp + ", \"mFinancialStatus\":" + mFinancialStatus + ", \"mPayoutDate\":" + mPayoutDate + ", \"mDeviceModel\":" + mDeviceModel + ", \"mProductTitle\":" + mProductTitle + ", \"mProductID\":" + mProductID + ", \"mCurrencyOfSale\":" + mCurrencyOfSale + ", \"mItemPrice\":" + mItemPrice + ", \"mTaxesCollected\":" + mTaxesCollected + ", \"mChargedAmount\":" + mChargedAmount + ", \"mMerchantCurrency\":" + mMerchantCurrency + ", \"mEstimatedFXRate\":" + mEstimatedFXRate + ", \"mMerchantReceives\":" + mMerchantReceives + ", \"mCityOfBuyer\":" + mCityOfBuyer + ", \"mStateOfBuyer\":" + mStateOfBuyer + ", \"mPostalCodeOfBuyer\":" + mPostalCodeOfBuyer + ", \"mCountryOfBuyer\":" + mCountryOfBuyer + "]";
    }

    public String toJSON() {
        // @formatter:off
	    return new StringBuilder().append("{\"OrderNumber\":\"").append(mOrderNumber).append("\"")
	            .append(", \"OrderChargedDate\":\"").append(mOrderChargedDate).append("\"")
                .append(", \"OrderChargedTimestamp\":\"").append(mOrderChargedTimestamp).append("\"")
                .append(", \"FinancialStatus\":\"").append(mFinancialStatus).append("\"")
                .append(", \"PayoutDate\":\"").append(mPayoutDate).append("\"")
                .append(", \"DeviceModel\":\"").append(mDeviceModel).append("\"")
                .append(", \"ProductTitle\":\"").append(mProductTitle).append("\"")
                .append(", \"ProductID\":\"").append(mProductID).append("\"")
                .append(", \"CurrencyOfSale\":\"").append(mCurrencyOfSale).append("\"")
                .append(", \"ItemPrice\":\"").append(mItemPrice).append("\"")
                .append(", \"TaxesCollected\":\"").append(mTaxesCollected).append("\"")
                .append(", \"ChargedAmount\":\"").append(mChargedAmount).append("\"")
                .append(", \"MerchantCurrency\":\"").append(mMerchantCurrency).append("\"")
                .append(", \"EstimatedFXRate\":\"").append(mEstimatedFXRate).append("\"")
                .append(", \"MerchantReceives\":\"").append(mMerchantReceives).append("\"")
                .append(", \"CityOfBuyer\":\"").append(mCityOfBuyer).append("\"")
                .append(", \"StateOfBuyer\":\"").append(mStateOfBuyer).append("\"")
                .append(", \"PostalCodeOfBuyer\":\"").append(mPostalCodeOfBuyer).append("\"")
                .append(", \"CountryOfBuyer\":\"").append(mCountryOfBuyer).append("\"")
                .append("}").toString();
        // @formatter:on
	}

}

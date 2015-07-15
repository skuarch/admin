package model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author skuarch
 */
public class Payment implements Serializable {
   
    private long id;
    private BigDecimal amount;
    private Cashier cashier;
    private Secret secret;
    private Recipient recipient;
    private long behalf;
    private String behalfBrand;
    private byte discountPercentage = 12;
    private AffiliateType affiliateType;
    private PaymentStatus paymentStatus;
    private String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private String lastUpdate;
    private byte isSoftDeleted = 0;
    private BigDecimal profit;
    private BigDecimal totalPay;
    
    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Secret getSecret() {
        return secret;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getBehalf() {
        return behalf;
    }

    public void setBehalf(long behalf) {
        this.behalf = behalf;
    }    

    public AffiliateType getAffiliateType() {
        return affiliateType;
    }

    public void setAffiliateType(AffiliateType affiliateType) {
        this.affiliateType = affiliateType;
    }    

    public String getBehalfBrand() {
        return behalfBrand;
    }

    public void setBehalfBrand(String behalfBrand) {
        this.behalfBrand = behalfBrand;
    }

    public byte getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(byte discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }
}

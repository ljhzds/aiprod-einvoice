package com.asiainfo.einvoice.core.def;

/**
 * Created by huangjh on 16/4/8.
 */
public class InvoiceItemMsg {
    private String itemName;
    private String itemUnit;
    private long itemNumb;
    private long itemPrice;
    private String itemSpec;
    private long itemAmount;
    private long itemFaxRate;
    private long itemFax;
    private String spbm;// 商品编码
    private String zxbm;// 自行编码
    private String hxbz;// 含税标志
    private String fpxz;// 发票性质

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public long getItemNumb() {
        return itemNumb;
    }

    public void setItemNumb(long itemNumb) {
        this.itemNumb = itemNumb;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public long getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(long itemAmount) {
        this.itemAmount = itemAmount;
    }

    public long getItemFaxRate() {
        return itemFaxRate;
    }

    public void setItemFaxRate(long itemFaxRate) {
        this.itemFaxRate = itemFaxRate;
    }

    public long getItemFax() {
        return itemFax;
    }

    public void setItemFax(long itemFax) {
        this.itemFax = itemFax;
    }

    public String getSpbm() {
        return spbm;
    }

    public void setSpbm(String spbm) {
        this.spbm = spbm;
    }

    public String getZxbm() {
        return zxbm;
    }

    public void setZxbm(String zxbm) {
        this.zxbm = zxbm;
    }

    public String getHxbz() {
        return hxbz;
    }

    public void setHxbz(String hxbz) {
        this.hxbz = hxbz;
    }

    public String getFpxz() {
        return fpxz;
    }

    public void setFpxz(String fpxz) {
        this.fpxz = fpxz;
    }
}

package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceDsDtlValue extends DataStructInterface{

  public final static  String S_Zxbm = "ZXBM";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Hxbz = "HXBZ";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ItemUnit = "ITEM_UNIT";
  public final static  String S_Fpxz = "FPXZ";
  public final static  String S_Spbm = "SPBM";
  public final static  String S_ItemName = "ITEM_NAME";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_ItemNumb = "ITEM_NUMB";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_ItemFaxRate = "ITEM_FAX_RATE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_InvoiceDsDetailId = "INVOICE_DS_DETAIL_ID";
  public final static  String S_ItemFax = "ITEM_FAX";
  public final static  String S_ItemSpec = "ITEM_SPEC";
  public final static  String S_ItemAmount = "ITEM_AMOUNT";
  public final static  String S_ItemPrice = "ITEM_PRICE";


public String getZxbm();

public long getInvoiceDsId();

public String getHxbz();

public String getRemarks();

public String getItemUnit();

public String getFpxz();

public String getSpbm();

public String getItemName();

public String getExt1();

public int getItemNumb();

public String getExt2();

public String getNotes();

public String getExt3();

public String getExt4();

public String getExt5();

public long getItemFaxRate();

public String getSharding();

public long getInvoiceDsDetailId();

public long getItemFax();

public String getItemSpec();

public long getItemAmount();

public long getItemPrice();


public  void setZxbm(String value);

public  void setInvoiceDsId(long value);

public  void setHxbz(String value);

public  void setRemarks(String value);

public  void setItemUnit(String value);

public  void setFpxz(String value);

public  void setSpbm(String value);

public  void setItemName(String value);

public  void setExt1(String value);

public  void setItemNumb(int value);

public  void setExt2(String value);

public  void setNotes(String value);

public  void setExt3(String value);

public  void setExt4(String value);

public  void setExt5(String value);

public  void setItemFaxRate(long value);

public  void setSharding(String value);

public  void setInvoiceDsDetailId(long value);

public  void setItemFax(long value);

public  void setItemSpec(String value);

public  void setItemAmount(long value);

public  void setItemPrice(long value);
}

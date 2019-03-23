package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceInstValue extends DataStructInterface{

  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_InvoiceCzdm = "INVOICE_CZDM";
  public final static  String S_OldInvoiceNumber = "OLD_INVOICE_NUMBER";
  public final static  String S_InvoiceQqddh = "INVOICE_QQDDH";
  public final static  String S_InvoiceContent = "INVOICE_CONTENT";
  public final static  String S_IssuingTime = "ISSUING_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_InvoicePrice = "INVOICE_PRICE";
  public final static  String S_InvoiceType = "INVOICE_TYPE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_ChReason = "CH_REASON";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_InvoiceTax = "INVOICE_TAX";
  public final static  String S_IssuingType = "ISSUING_TYPE";
  public final static  String S_InvoiceHead = "INVOICE_HEAD";
  public final static  String S_IssuingFlag = "ISSUING_FLAG";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_InvoiceVerifyCode = "INVOICE_VERIFY_CODE";
  public final static  String S_InvoiceNumber = "INVOICE_NUMBER";
  public final static  String S_OldInvoiceInstanceId = "OLD_INVOICE_INSTANCE_ID";
  public final static  String S_InvoiceEwm = "INVOICE_EWM";
  public final static  String S_InvoiceCode = "INVOICE_CODE";
  public final static  String S_InvoiceFwm = "INVOICE_FWM";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_IssuingChannel = "ISSUING_CHANNEL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_OldInvoiceCode = "OLD_INVOICE_CODE";
  public final static  String S_InvoiceAmount = "INVOICE_AMOUNT";
  public final static  String S_InvoiceQqlsh = "INVOICE_QQLSH";


public long getCreateOpId();

public String getInvoiceCzdm();

public String getOldInvoiceNumber();

public String getInvoiceQqddh();

public String getInvoiceContent();

public Timestamp getIssuingTime();

public String getRemarks();

public String getNotes();

public long getInvoiceInstanceId();

public long getInvoicePrice();

public String getInvoiceType();

public String getSharding();

public String getChReason();

public Timestamp getCreateTime();

public long getCreateOrgId();

public long getInvoiceTax();

public String getIssuingType();

public String getInvoiceHead();

public String getIssuingFlag();

public long getInvoiceDsId();

public String getInvoiceVerifyCode();

public String getInvoiceNumber();

public long getOldInvoiceInstanceId();

public String getInvoiceEwm();

public String getInvoiceCode();

public String getInvoiceFwm();

public String getExt1();

public String getExt2();

public String getExt3();

public String getExt4();

public String getIssuingChannel();

public String getExt5();

public String getOldInvoiceCode();

public long getInvoiceAmount();

public String getInvoiceQqlsh();


public  void setCreateOpId(long value);

public  void setInvoiceCzdm(String value);

public  void setOldInvoiceNumber(String value);

public  void setInvoiceQqddh(String value);

public  void setInvoiceContent(String value);

public  void setIssuingTime(Timestamp value);

public  void setRemarks(String value);

public  void setNotes(String value);

public  void setInvoiceInstanceId(long value);

public  void setInvoicePrice(long value);

public  void setInvoiceType(String value);

public  void setSharding(String value);

public  void setChReason(String value);

public  void setCreateTime(Timestamp value);

public  void setCreateOrgId(long value);

public  void setInvoiceTax(long value);

public  void setIssuingType(String value);

public  void setInvoiceHead(String value);

public  void setIssuingFlag(String value);

public  void setInvoiceDsId(long value);

public  void setInvoiceVerifyCode(String value);

public  void setInvoiceNumber(String value);

public  void setOldInvoiceInstanceId(long value);

public  void setInvoiceEwm(String value);

public  void setInvoiceCode(String value);

public  void setInvoiceFwm(String value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);

public  void setIssuingChannel(String value);

public  void setExt5(String value);

public  void setOldInvoiceCode(String value);

public  void setInvoiceAmount(long value);

public  void setInvoiceQqlsh(String value);
}

package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceDsValue extends DataStructInterface{

  public final static  String S_Sky = "SKY";
  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_CustId = "CUST_ID";
  public final static  String S_GhfDhhm = "GHF_DHHM";
  public final static  String S_XhfNsrmc = "XHF_NSRMC";
  public final static  String S_XhfNsrsbh = "XHF_NSRSBH";
  public final static  String S_InvoiceContent = "INVOICE_CONTENT";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_DsState = "DS_STATE";
  public final static  String S_KpfMc = "KPF_MC";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Notes = "NOTES";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_InvoiceType = "INVOICE_TYPE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_Kpy = "KPY";
  public final static  String S_Fhy = "FHY";
  public final static  String S_TotalPrice = "TOTAL_PRICE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_GhfNsrmc = "GHF_NSRMC";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_XhfDz = "XHF_DZ";
  public final static  String S_IssuingType = "ISSUING_TYPE";
  public final static  String S_InvoiceHead = "INVOICE_HEAD";
  public final static  String S_SoOrderId = "SO_ORDER_ID";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_XhfDhhm = "XHF_DHHM";
  public final static  String S_AcctId = "ACCT_ID";
  public final static  String S_GhfQylx = "GHF_QYLX";
  public final static  String S_KpfSbh = "KPF_SBH";
  public final static  String S_SoOrderSeria = "SO_ORDER_SERIA";
  public final static  String S_GhfDz = "GHF_DZ";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_IssuingChannel = "ISSUING_CHANNEL";
  public final static  String S_TotalTax = "TOTAL_TAX";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_KpfDzdah = "KPF_DZDAH";
  public final static  String S_GhfNsrsbh = "GHF_NSRSBH";
  public final static  String S_XhfYhzh = "XHF_YHZH";
  public final static  String S_GhfYhzh = "GHF_YHZH";
  public final static  String S_TotalAmount = "TOTAL_AMOUNT";
  public final static  String S_Dkbz = "DKBZ";


public String getSky();

public long getCreateOpId();

public long getCustId();

public String getGhfDhhm();

public String getXhfNsrmc();

public String getXhfNsrsbh();

public String getInvoiceContent();

public long getUserId();

public String getRemarks();

public String getDsState();

public String getKpfMc();

public String getBusiType();

public String getNotes();

public String getBillId();

public String getInvoiceType();

public String getSharding();

public String getKpy();

public String getFhy();

public long getTotalPrice();

public Timestamp getCreateTime();

public String getGhfNsrmc();

public long getCreateOrgId();

public String getXhfDz();

public String getIssuingType();

public String getInvoiceHead();

public String getSoOrderId();

public long getInvoiceDsId();

public String getXhfDhhm();

public long getAcctId();

public String getGhfQylx();

public String getKpfSbh();

public String getSoOrderSeria();

public String getGhfDz();

public String getExt1();

public String getExt2();

public String getExt3();

public String getExt4();

public String getIssuingChannel();

public long getTotalTax();

public String getExt5();

public String getKpfDzdah();

public String getGhfNsrsbh();

public String getXhfYhzh();

public String getGhfYhzh();

public long getTotalAmount();

public String getDkbz();


public  void setSky(String value);

public  void setCreateOpId(long value);

public  void setCustId(long value);

public  void setGhfDhhm(String value);

public  void setXhfNsrmc(String value);

public  void setXhfNsrsbh(String value);

public  void setInvoiceContent(String value);

public  void setUserId(long value);

public  void setRemarks(String value);

public  void setDsState(String value);

public  void setKpfMc(String value);

public  void setBusiType(String value);

public  void setNotes(String value);

public  void setBillId(String value);

public  void setInvoiceType(String value);

public  void setSharding(String value);

public  void setKpy(String value);

public  void setFhy(String value);

public  void setTotalPrice(long value);

public  void setCreateTime(Timestamp value);

public  void setGhfNsrmc(String value);

public  void setCreateOrgId(long value);

public  void setXhfDz(String value);

public  void setIssuingType(String value);

public  void setInvoiceHead(String value);

public  void setSoOrderId(String value);

public  void setInvoiceDsId(long value);

public  void setXhfDhhm(String value);

public  void setAcctId(long value);

public  void setGhfQylx(String value);

public  void setKpfSbh(String value);

public  void setSoOrderSeria(String value);

public  void setGhfDz(String value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);

public  void setIssuingChannel(String value);

public  void setTotalTax(long value);

public  void setExt5(String value);

public  void setKpfDzdah(String value);

public  void setGhfNsrsbh(String value);

public  void setXhfYhzh(String value);

public  void setGhfYhzh(String value);

public  void setTotalAmount(long value);

public  void setDkbz(String value);
}

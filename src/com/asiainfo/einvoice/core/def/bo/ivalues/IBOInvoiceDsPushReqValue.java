package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceDsPushReqValue extends DataStructInterface{

  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PushTarget = "PUSH_TARGET";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PushReqId = "PUSH_REQ_ID";
  public final static  String S_PushWay = "PUSH_WAY";


public String getExt1();

public String getExt2();

public String getNotes();

public String getExt3();

public String getExt4();

public String getExt5();

public long getInvoiceDsId();

public String getSharding();

public String getPushTarget();

public String getRemarks();

public long getPushReqId();

public String getPushWay();


public  void setExt1(String value);

public  void setExt2(String value);

public  void setNotes(String value);

public  void setExt3(String value);

public  void setExt4(String value);

public  void setExt5(String value);

public  void setInvoiceDsId(long value);

public  void setSharding(String value);

public  void setPushTarget(String value);

public  void setRemarks(String value);

public  void setPushReqId(long value);

public  void setPushWay(String value);
}

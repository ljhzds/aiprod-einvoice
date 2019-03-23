package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceDsAttrValue extends DataStructInterface{

  public final static  String S_Notes = "NOTES";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_AttrValDesc = "ATTR_VAL_DESC";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_AttrCode = "ATTR_CODE";
  public final static  String S_AttrVal = "ATTR_VAL";


public String getNotes();

public String getAttrName();

public long getInvoiceDsId();

public String getSharding();

public String getAttrValDesc();

public String getState();

public String getRemarks();

public long getAttrId();

public String getAttrCode();

public String getAttrVal();


public  void setNotes(String value);

public  void setAttrName(String value);

public  void setInvoiceDsId(long value);

public  void setSharding(String value);

public  void setAttrValDesc(String value);

public  void setState(String value);

public  void setRemarks(String value);

public  void setAttrId(long value);

public  void setAttrCode(String value);

public  void setAttrVal(String value);
}

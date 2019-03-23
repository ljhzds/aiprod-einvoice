package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceInstItemValue extends DataStructInterface{

  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_InvoiceDsDetailId = "INVOICE_DS_DETAIL_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_InvoiceInstanceItemId = "INVOICE_INSTANCE_ITEM_ID";


public String getNotes();

public long getInvoiceInstanceId();

public String getSharding();

public long getInvoiceDsDetailId();

public String getRemarks();

public long getInvoiceInstanceItemId();


public  void setNotes(String value);

public  void setInvoiceInstanceId(long value);

public  void setSharding(String value);

public  void setInvoiceDsDetailId(long value);

public  void setRemarks(String value);

public  void setInvoiceInstanceItemId(long value);
}

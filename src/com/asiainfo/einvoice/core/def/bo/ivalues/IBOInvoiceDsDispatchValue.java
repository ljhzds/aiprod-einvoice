package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceDsDispatchValue extends DataStructInterface{

  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_TargetSharding = "TARGET_SHARDING";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_ExecuteTime = "EXECUTE_TIME";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_DispatchKind = "DISPATCH_KIND";
  public final static  String S_DispatchCount = "DISPATCH_COUNT";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_DispatchResult = "DISPATCH_RESULT";
  public final static  String S_DispatchId = "DISPATCH_ID";


public long getInvoiceDsId();

public String getState();

public String getRemarks();

public String getTargetSharding();

public String getNotes();

public long getInvoiceInstanceId();

public Timestamp getExecuteTime();

public String getSharding();

public String getDispatchKind();

public int getDispatchCount();

public Timestamp getCreateTime();

public String getDispatchResult();

public long getDispatchId();


public  void setInvoiceDsId(long value);

public  void setState(String value);

public  void setRemarks(String value);

public  void setTargetSharding(String value);

public  void setNotes(String value);

public  void setInvoiceInstanceId(long value);

public  void setExecuteTime(Timestamp value);

public  void setSharding(String value);

public  void setDispatchKind(String value);

public  void setDispatchCount(int value);

public  void setCreateTime(Timestamp value);

public  void setDispatchResult(String value);

public  void setDispatchId(long value);
}

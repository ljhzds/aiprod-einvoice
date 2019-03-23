package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoicePushTaskHisValue extends DataStructInterface{

  public final static  String S_PushContent = "PUSH_CONTENT";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PushTarget = "PUSH_TARGET";
  public final static  String S_PushTime = "PUSH_TIME";
  public final static  String S_State = "STATE";
  public final static  String S_PushResult = "PUSH_RESULT";
  public final static  String S_PushTaskId = "PUSH_TASK_ID";
  public final static  String S_Reamrks = "REAMRKS";
  public final static  String S_PushWay = "PUSH_WAY";


public String getPushContent();

public String getNotes();

public long getInvoiceInstanceId();

public long getInvoiceDsId();

public String getSharding();

public String getPushTarget();

public Timestamp getPushTime();

public String getState();

public String getPushResult();

public long getPushTaskId();

public String getReamrks();

public String getPushWay();


public  void setPushContent(String value);

public  void setNotes(String value);

public  void setInvoiceInstanceId(long value);

public  void setInvoiceDsId(long value);

public  void setSharding(String value);

public  void setPushTarget(String value);

public  void setPushTime(Timestamp value);

public  void setState(String value);

public  void setPushResult(String value);

public  void setPushTaskId(long value);

public  void setReamrks(String value);

public  void setPushWay(String value);
}

package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoicePresInstValue extends DataStructInterface{

  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_PersistentKey = "PERSISTENT_KEY";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PersistentType = "PERSISTENT_TYPE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_Url = "URL";
  public final static  String S_PersistentPath = "PERSISTENT_PATH";


public long getCreateOpId();

public long getInvoiceInstanceId();

public String getPersistentKey();

public String getSharding();

public String getPersistentType();

public Timestamp getCreateTime();

public long getCreateOrgId();

public String getUrl();

public String getPersistentPath();


public  void setCreateOpId(long value);

public  void setInvoiceInstanceId(long value);

public  void setPersistentKey(String value);

public  void setSharding(String value);

public  void setPersistentType(String value);

public  void setCreateTime(Timestamp value);

public  void setCreateOrgId(long value);

public  void setUrl(String value);

public  void setPersistentPath(String value);
}
